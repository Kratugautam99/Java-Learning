package Kratu.company;
public class C7MethodsTypesUnderstanding {
    static void multiple(int a){
        for (int x = 1; x <= 10; x++){
            System.out.printf("%d X %d = %d\n",a,x,a*x);
        }
    }
    void multiple(int a, int y){
        for (int x = 1; x <= y; x++){
            System.out.printf("%d X %d = %d\n",a,x,a*x);
        }
    }
    static void starasc(int a) {
        if (a > 0) {
            starasc(a - 1);
            for (int i = 0; i < a; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    void stardesc(int a){
        for (int i = a; i > 0; i--){
            for (int j = 0; j < i; j++){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
    static int fibonacciR(int a){
        int x = 0;
        if (a > 1){
            x += fibonacciR(a-1)+fibonacciR(a-2);
        }
        else if (a == 1){
            x = 1;
        }
        else if (a == 0){
            x = 0;
        }
        return x;
    }
    int fibonacciI(int a) {
        int x = 0, y = 1, z;
       if (a == 0){
           return x;
        }
       else if (a == 1){
           return y;
       }
       else{
           for (int i = 2; i <= a; i++){
               z = x + y;
               x = y;
               y = z;
           }
       return y;
       }
    }
    public static void main(String[] args){
        multiple(3);
        System.out.println("");
        C7MethodsTypesUnderstanding bob = new C7MethodsTypesUnderstanding();
        bob.multiple(9,20);
        System.out.println("");
        starasc(8);
        bob.stardesc(9);
        System.out.println("");
        System.out.println(fibonacciR(9));
        System.out.println(bob.fibonacciI(9));
    }
}
