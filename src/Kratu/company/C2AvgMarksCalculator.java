package Kratu.company;
import java.util.Scanner;
public class C2AvgMarksCalculator {
    public static void main1() {
        Scanner K = new Scanner(System.in);
        System.out.println("Enter Marks of 5 Subjects: ");
        boolean a1 = K.hasNextInt();
        int a = K.nextInt();
        boolean b1 = K.hasNextInt();
        int b = K.nextInt();
        boolean c1 = K.hasNextInt();
        int c = K.nextInt();
        boolean d1 = K.hasNextInt();
        int d = K.nextInt();
        boolean e1 = K.hasNextInt();
        int e = K.nextInt();
        if (a1 && b1 && c1 && d1 && e1) {
            double sum = (a + b + c + d + e) / 5.0;
            System.out.print("Average Marks: " + sum + ".");
        } else {
            System.out.print("Make sure all Inputs are Integers.");
        }
    }
    public static void main2() {
        Scanner K = new Scanner(System.in);
        System.out.println("Enter Marks of 5 Subjects: ");
        int sum = 0;
        boolean allValid = true;
        for (int i = 0; i < 5; i++) {
            if (K.hasNextInt()) {
                sum += K.nextInt();
            } else {
                allValid = false;
                System.out.println("Make sure all inputs are integers.");
                K.next();
                break;
            }
        }
        if (allValid) {
            double average = (double) sum / 5.0;
            System.out.println("Average Marks: " + average + ".");
        }
        K.close();
    }
    public static void main(String[] args){
        System.out.println("By Method 1");
        main1();
        System.out.println("\n");
        System.out.println("By Method 2");
        main2();
    }
}