package Kratu.company;
import  java.util.Random;
import java.util.Scanner;
public class C3OperationalUnderstanding {
    public static void main(String[] args){
         Random A = new Random();
         System.out.println("Type between 0 and 100 both Included.");
         Scanner K = new Scanner(System.in);
         boolean X = true;
             while (X){
                 if (K.hasNextInt()) {
                     int R = A.nextInt(100);
                     int G = K.nextInt();
                     if (0 <= G && 100 >= G) {
                         X = false;
                         int T = A.nextInt(2);
                         if (T==1 && R>G){
                             System.out.println("Sorry, You lost as the competition was to check if the Number is Greater. Your Number is " + G + " and Computer Number is " + R +".");
                         }
                         else if (T==0 && R<G) {
                             System.out.println("Sorry, You lost as the competition was to check if the Number is Smaller. Your Number is " + G + " and Computer Number is " + R +".");
                         }
                         else if (T==1 && R<G) {
                             System.out.println("Wow, You won as the competition was to check if the Number is Greater. Your Number is " + G + " and Computer Number is " + R +".");
                         }
                         else if (T==0 && R>G){
                             System.out.println("Wow, You won as the competition was to check if the Number is Smaller. Your Number is " + G + " and Computer Number is " + R +".");
                         }
                         else {
                             System.out.println("You both Tied at Number " + G + " Play Again!");
                             X = true;
                         }
                     } else {
                         System.out.println("Enter No. as Instructed.");
                     }
                 }
                 else{
                     System.out.println("Enter No. as Instructed.");
                     K.next();
                 }
             }
        }
    }

