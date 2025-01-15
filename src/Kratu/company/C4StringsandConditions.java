package Kratu.company;

import java.lang.classfile.instruction.SwitchCase;

public class C4StringofKinds {
    public static void stringmethods(){
           String name = "Kratu";
           float age = 19.3333333333f;
           System.out.printf("Dear\t %s, H\"ow d\no you\' %10.3f?", name,age);
           String Lowername = "Kratu".toLowerCase();
           System.out.print("\n");
           System.out.println(Lowername);
           System.out.format("Dear Customer, Your Name is %s and Your Age is %1.3f, Formatted by method 2.\n",Lowername,age);
    }
    public static void Divisibleby5(int... numbers) {
        for (int number : numbers) {
            if (number%5 == 0){
                System.out.println("Divisible by 5.");
            }
            else{
                System.out.println("Not Divisible by 5.");
            }
        }
    }
    public static void spacecheck(String X){
        int spacecount = X.length();
        String Y = X.replaceAll(" ","");
        int newspacecount = Y.length();
        System.out.printf("Total Number of Spaces in Provided String is %d.\n",(spacecount-newspacecount));
    }
    public static void websitetype(String X){
        /*
        switch(X){
            case "com":
                System.out.println("Commercial Site");
                break;
            case "org":
                System.out.println("Organization Site");
                break;
            case "in":
                System.out.println("Indian Site");
                break;
            default:
                System.out.println("Any other Custom Site Domain Name");
        }
         */
        switch(X){
            case "com" -> System.out.println("Commercial Site");
            case "org" -> System.out.println("Organization Site");
            case "in" -> System.out.println("Indian Site");
            default -> {
                System.out.println("Any other Custom Site Domain Name");
                System.out.println("Over and out");
            }
        }
    }
    public static void main(String[] args){
        stringmethods();
        System.out.println("");
        spacecheck("         SDE at Microsoft          ");
        System.out.println("");
        Divisibleby5(19,9,27,8,2005);
    }
}
