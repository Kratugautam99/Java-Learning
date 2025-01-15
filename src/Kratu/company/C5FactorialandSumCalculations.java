package Kratu.company;
public class C5Factorialandothercalculations {
    public static void factorial(int X) {
        int OGx = X;
        int i = 1;
        int fact = 1;
        do {
            if (X==0){
             X++;
             continue;
            }
            fact *= i;
            i ++;
            if (i > X){
                break;
            }
        } while (true);
        System.out.printf("The factorial of the Number %d is %d.\n",OGx,fact);
    }
    public static void nthNumberSums(int X, String Y) {
        switch (Y) {
            case "even numbers" -> System.out.printf("The Sum of %d Even Numbers is %d.",X,(X * (X + 1)));
            case "odd numbers" -> System.out.printf("The Sum of %d Odd Numbers is %d.",X,(X*X));
            case "square numbers" -> System.out.printf("The Sum of %d Square Numbers is %d.",X,(X*(X+1)*(2*X+1)/6));
            case "cube numbers" -> System.out.printf("The Sum of %d Cube Numbers is %d.",X,Math.sqrt(X * (X + 1)/2));
            default -> {
                System.out.println("Make sure you write in small case and write even/odd/square/cube numbers, \nif your Y/String input is in different manner, no problem as default is sum of natural numbers.\nOutput is in terms of natural numbers, you can expect abnormalities with non-natural X/int input.");
                System.out.printf("The Sum of %d Natural Numbers are %d.",X,(X*(X + 1)/2));
            }
        }
    }
    public static void main(String[] args){
        factorial(0);
        System.out.println("");
        nthNumberSums(2,"odd numbers");
    }
}
