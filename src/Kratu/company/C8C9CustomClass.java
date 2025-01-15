package Kratu.company;
import java.util.Scanner;
class Employee {
    int id;
    String name;
    int salary;
    static Scanner K = new Scanner(System.in);
    public int getSalary() {
        return salary;
    }
    public String getName() {
        return name;
    }
    public int getId(){
        return id;
    }
    public void setSalary() {
        K.nextLine();
        System.out.println("Enter Salary: ");
        while (true) {
            if (K.hasNextInt()) {
                salary = K.nextInt();
                break;
            } else {
                System.out.println("Haha! Funny but Invalid.");
                K.next();
            }
        }
    }
    public void setID() {
        K.nextLine();
        System.out.println("Enter ID: ");
        while (true) {
            if (K.hasNextInt()) {
                id = K.nextInt();
                break;
            } else {
                System.out.println("Haha! Funny but Invalid.");
                K.next();
            }
        }
    }
    public void setName() {
        K.nextLine();
        System.out.println("Enter Full Name: ");
        while (true) {
            if (!(K.hasNextInt())) {
                String name1 = K.next();
                String name2 = K.next();
                name = name1+" "+name2;
                break;
            } else {
                System.out.println("Haha! Funny but Invalid.");
                K.next();
            }
        }
    }
}
class Cone{
    double pie = Math.PI;
    double r,h,l;
    public Cone(int r){
        this(r,1);
        System.out.println("Cone is now a Flat Disk with unit Height.");
    }
    public Cone(int r, int h){
        this.r = r;
        this.h = h;
        this.l = Math.sqrt(r*r+h*h);
        System.out.println("\n");
        System.out.println("Cone Dimensions Acquired.");
    }
    public double getLateralSurfaceArea() {
        double LSA = pie*r*l;
        return LSA;
    }
    public double getBaseSurfaceArea() {
        double BSA = pie*r*r;
        return BSA;
    }
    public double getTotalSurfaceArea() {
        double TSA = this.getBaseSurfaceArea() + this.getLateralSurfaceArea();
        return TSA;
    }
    public double getVolume() {
        double Volume = this.getBaseSurfaceArea()*h/3;
        return Volume;
    }
}
public class C8C9CustomClass {
    public static void main(String[] args) {
        Employee Naukar = new Employee();
        System.out.println("To unlock usage of methods, Press Enter.");
        Naukar.setID();
        Naukar.setName();
        Naukar.setSalary();
        System.out.printf("The Employee ID: " + Naukar.getId() + ", Full Name: " + Naukar.getName() + ", Salary: "+ Naukar.getSalary()+"Rs.");
        Cone TirePuncher = new Cone(3,4);
        System.out.printf("Surface Areas are %3.2f(Base) square units, %3.2f(Lateral) square units, %3.2f(Total) square units and Volume is %3.2f cube units.",TirePuncher.getBaseSurfaceArea(),TirePuncher.getLateralSurfaceArea(),TirePuncher.getTotalSurfaceArea(),TirePuncher.getVolume());
        Cone FlatDisk = new Cone(3);
        System.out.printf("Surface Areas are %3.2f(Base) square units, %3.2f(Lateral) square units, %3.2f(Total) square units and Volume is %3.2f cube units.",FlatDisk.getBaseSurfaceArea(),FlatDisk.getLateralSurfaceArea(),FlatDisk.getTotalSurfaceArea(),FlatDisk.getVolume());
    }
}

