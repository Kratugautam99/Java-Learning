package Kratu.company;
import  java.util.Random;
import java.util.Scanner;
public class C3YouVsPCLuckyNumberGuessing {
    public static void main(String[] args) {
        Random A = new Random();
        Scanner K = new Scanner(System.in);
        boolean RoundBool = false;
        int Round = 0;
        System.out.println("Type Number of Rounds.");
        if (K.hasNextInt()) {
            Round = K.nextInt();
            RoundBool = Round > 0;
        }
        else{
            System.out.println("Invalid Input!");
        }
        int Y = 0;
        int P = 0;
        boolean X = true;
        while (X && RoundBool) {
            Round -= 1;
            System.out.println("Type between 0 and 100 both Included.");
            if (K.hasNextInt()) {
                int R = A.nextInt(100);
                int G = K.nextInt();
                if (0 <= G && 100 >= G) {
                    int T = A.nextInt(2);
                    if (T == 1 && R > G) {
                        System.out.println("Sorry, You lost as the competition was to check if the Number is Greater. Your Number is " + G + " and Computer Number is " + R + ".");
                        P += 1;
                        System.out.println("Computer Score: " + P + " and Your Score: " + Y + ".\n");
                    } else if (T == 0 && R < G) {
                        System.out.println("Sorry, You lost as the competition was to check if the Number is Smaller. Your Number is " + G + " and Computer Number is " + R + ".");
                        P += 1;
                        System.out.println("Computer Score: " + P + " and Your Score: " + Y + ".\n");
                    } else if (T == 1 && R < G) {
                        System.out.println("Wow, You won as the competition was to check if the Number is Greater. Your Number is " + G + " and Computer Number is " + R + ".");
                        Y += 1;
                        System.out.println("Computer Score: " + P + " and Your Score: " + Y + ".\n");
                    } else if (T == 0 && R > G) {
                        System.out.println("Wow, You won as the competition was to check if the Number is Smaller. Your Number is " + G + " and Computer Number is " + R + ".");
                        Y += 1;
                        System.out.println("Computer Score: " + P + " and Your Score: " + Y + ".\n");
                    } else {
                        System.out.println("You both Tied at Number " + G + ".");
                        System.out.println("Computer Score: " + P + " and Your Score: " + Y + ".");
                    }
                } else {
                    System.out.println("Enter Number as Instructed.\n");
                }
            } else {
                System.out.println("Enter Number as Instructed.\n");
                K.next();
            }
            if (Round <= 0 && Y==P){
                System.out.println("Tie Breaker!!!");
            }
            if (Round <= 0 && Y != P) {
                X = false;
            }
        }
       if (P > Y){
           System.out.println("Overall Winner is Computer with points " + P + " as opposed to Your points which is " + Y + ".");
       }
       else if (RoundBool){
           System.out.println("Overall Winner is YOU with points " + Y + " as opposed to PC points which is " + P + ".");
       }
    }
}

