package learn_mongodb;

import learn_mongodb.entity.Address;
import learn_mongodb.entity.Order;
import learn_mongodb.entity.Product;
import learn_mongodb.repository.OrderRepository;
import learn_mongodb.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RelationshipMongoTests {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void testOrderCreation() {

        Product laptop = Product.builder()
                .name("Gaming Laptop")
                .category("Electronics")
                .price(1299.99)
                .build();
        laptop = productRepository.save(laptop);

        Product phone = Product.builder()
                .name("IPhon 22")
                .category("Electronics")
                .price(1699.99)
                .build();
        phone = productRepository.save(phone);


        Order order = Order.builder()
                .status("READY")
                .quantity(2)
                .totalPrice(100.0)
                .products(List.of(laptop, phone))
                .address(Address.builder()
                        .line1("LIne 1 Address")
                        .city("Delhi")
                        .state("Delhi")
                        .build())
                .build();

        order = orderRepository.insert(order);

        System.out.println(order.getStatus());
    }

    @Test
    public void testOrderFetch() {
//        var orders = orderRepository.findByAddressCity("Delhi");
        var orders = orderRepository.findByCity("Delhi");

        orders.forEach(System.out::println);
    }
}
