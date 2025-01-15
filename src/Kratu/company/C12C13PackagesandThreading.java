package Kratu.company;
import java.lang.Thread;
class Code1 extends Thread {
    @Override
    public void run() {
        int i = 0;
        try {Thread.sleep(1000);}
        catch (InterruptedException e) {System.out.println(e);}
        while (i < 25) {
            System.out.println("Process 1 using Thread Class.");
            i += 1;
        }
    }
}

class Code2 extends Thread {
    public Code2(String name){
        super(name);
    }
    @Override
    public void run() {
        int i = 0;
        while (i < 100) {
            System.out.println("Process 2 using Thread Class");
            i += 1;
        }
    }
}

class Code3 implements Runnable {
    public void run() {
        int x = 0;
        while (100 > x) {
            System.out.println("Chad!");
            x++;
        }
    }
}

class Code4 implements Runnable {
    public void run() {
        int x = 0;
        while (100 > x) {
            System.out.println("BAD!");
            x++;
        }
    }
}

public class C12C13PackagesandThreading {
    public static void main(String[] args) {
        Code1 c1 = new Code1();
        Code2 c2 = new Code2("Kratu");
        Code3 b3 = new Code3();
        Code4 b4 = new Code4();
        Thread c3 = new Thread(b3);
        Thread c4 = new Thread(b4);
        c2.setPriority(Thread.MAX_PRIORITY);
        c3.setPriority(9);
        c1.start();
        try {c1.join();}
        catch (InterruptedException e) {System.out.println(e);}
        c2.start();
        c3.start();
        c4.start();
        System.out.println("c4 Priority: "+c4.getPriority()+" c2 Name: "+c2.getName());
    }
}
