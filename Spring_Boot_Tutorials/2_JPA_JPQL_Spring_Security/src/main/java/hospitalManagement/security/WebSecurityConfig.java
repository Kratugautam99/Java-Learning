package hospitalManagement.security;

import hospitalManagement.entity.type.PermissionType;
import hospitalManagement.entity.type.RoleType;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import static hospitalManagement.entity.type.PermissionType.*;
import static hospitalManagement.entity.type.RoleType.*;


@Configuration
@RequiredArgsConstructor
@Slf4j
@EnableMethodSecurity
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    private final HandlerExceptionResolver handlerExceptionResolver;
    
    @Bean
    public ForwardedHeaderFilter forwardedHeaderFilter() {
        return new ForwardedHeaderFilter();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // disable CSRF for APIs
            .csrf(csrf -> csrf.disable())
            // ifrequired session for JWT
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
            // authorization rules
            .authorizeHttpRequests(auth -> auth
                // Swagger / API docs open
                .requestMatchers(
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/api/v1/swagger-ui/**",
                    "/api/v1/v3/api-docs/**",
                    "/swagger-ui.html",
                    "/swagger-ui/index.html",
                    "/v3/api-docs/**", 
                    "/v3/api-docs.yaml"
                ).permitAll()
                // public + auth endpoints open
                .requestMatchers("/public/**", "/auth/**","/login/oauth2/**", "/oauth2/**").permitAll()
                // fine-grained permissions
                .requestMatchers(HttpMethod.DELETE, "/admin/**")
                    .hasAnyAuthority(APPOINTMENT_DELETE.name(), USER_MANAGE.name())
                .requestMatchers("/admin/**").hasRole(ADMIN.name())
                .requestMatchers("/doctors/**").hasAnyRole(DOCTOR.name(), ADMIN.name())
                // everything else requires authentication
                .anyRequest().authenticated()
            )
            // JWT filter
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            // OAuth2 login
            .oauth2Login(oauth2 -> oauth2
                .failureHandler((request, response, exception) -> {
                    log.error("OAuth2 error: {}", exception.getMessage());
                    handlerExceptionResolver.resolveException(request, response, null, exception);
                })
                .successHandler(oAuth2SuccessHandler)
            )
            // exception handling
            .exceptionHandling(exceptions -> 
                exceptions.accessDeniedHandler((request, response, accessDeniedException) -> {
                    handlerExceptionResolver.resolveException(request, response, null, accessDeniedException);
                })
            )
            // optional form login if you want a UI login page
            .formLogin(form -> form
                .loginPage("/api/v1/login")
                .permitAll()
            );

        return http.build();
    }
}
