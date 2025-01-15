package Kratu.company;
interface Animal {
    void eat();
    void sleep();
    String kingdomname = "Animalia";
}

abstract class Mammal implements Animal {
    String name;
    String classname ="Mammalia";

    Mammal(String name) {
        this.name = name;
    }
    public void kingdomName(){
        System.out.println(name+"'s Biological Kingdom is "+kingdomname+".");
    }
    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    void breathe() {
        System.out.println(name + " is breathing.");
    }
    abstract void reproduce();
}

class Dog extends Mammal {
    String breed;

    Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }
    public void className(){
        System.out.println(name+"'s Biological Class is "+super.classname+".");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println(name + " the " + breed + " is eating dog food.");
    }

    @Override
    public void reproduce(){
        System.out.println(name + " is working hard for the growth of it's species.");
    }

    void bark() {
        System.out.println(name + " is barking.");
    }
}

public class C10SuperandInterface {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy", "Golden Retriever");
        myDog.eat();
        myDog.sleep();
        myDog.breathe();
        myDog.bark();
        myDog.className();
        myDog.kingdomName();
        myDog.reproduce();
    }
}
