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

class Library{
    String[] storedbooks = new String[0];
    String[] issuedbooks = new String[0];
    public Library(String[] storedbooks, int maxissuenumber){
        System.out.println("\nThe library has just been established and is now open for Customers!!!");
        if (maxissuenumber > storedbooks.length){
            maxissuenumber = storedbooks.length-1;
        }
        String[] issuedbooks = new String[maxissuenumber];
        this.storedbooks = storedbooks;
        this.issuedbooks = issuedbooks;
    }
    void showAvailableBooks(){
        System.out.println("\nThe Available Books in Library.");
        int i = 1;
        for (String ele : storedbooks){
            System.out.printf("%d. %s\n", i++,ele);
        }
    }
    void showIssuedBooks(){
        System.out.println("\nThe Issued Books from Library.");
        int i = 1;
        for (String ele : issuedbooks){
            System.out.printf("%d. %s\n", i++,ele);
        }
    }
    void returnBook(int i){
        if (0 < i && i < issuedbooks.length+1){
            for (int j = issuedbooks.length-1; j >= 0; j--){
                if (issuedbooks[j] != null){
                    addBook(issuedbooks[j],false);
                    System.out.println("\nReturned Book: \"" + issuedbooks[j] +"\" to Library.");
                    issuedbooks[j] = null;
                    break;
                }
                else if (j == 0){
                    System.out.println("\nNo Book Issued.");
                }
            }
        } else {
            System.out.println("\nUse showIssuedBooks and type right number.");
        }
    }
    void issueBook(int i){
        if (0 < i && i < storedbooks.length+1){
             for (int j = 1; j <= issuedbooks.length; j++){
                 if (issuedbooks[j-1] == null){
                     issuedbooks[j-1] = storedbooks[i-1];
                     storedbooks[i-1] = null;
                     System.out.println("\nIssued Book: \"" + issuedbooks[j-1] +"\" from Library.");
                     break;
                 }
                 else if (j == issuedbooks.length){
                     System.out.println("\nMax Issue Amount Reached!, come back later.");
                 }
             }
        } else {
            System.out.println("\nUse showAvailableBooks and type right number.");
        }
    }
    void addBook(String book,boolean added) {
        int j = 0;
        for (String ele : storedbooks) {
            if (ele == null) {
                storedbooks[j] = book;
                break;
            } else if (j == storedbooks.length - 1) {
                String[] temp = new String[storedbooks.length + 5];
                int k = 0;
                for (String bele : storedbooks) {
                    temp[k++] = bele;
                    if (k == storedbooks.length) {
                        temp[k] = book;
                    }
                }
                storedbooks = temp;
            }
            j++;
        }
        if (added) {
            System.out.println("\nAdded New Book: \"" + book + "\" to the Library.");
        }
    }
    void addBook(String book){
        addBook(book,true);
    }
}
public class C10C11SuperandInterface {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy", "Golden Retriever");
        myDog.eat();
        myDog.sleep();
        myDog.breathe();
        myDog.bark();
        myDog.className();
        myDog.kingdomName();
        myDog.reproduce();
        String[] books = {"48 Laws of Power", "Atomic Habits", "Art of War", "Little Book of Stoicism", "How to Influence Friends and People?"};
        Library lib = new Library(books, 5);
        lib.addBook("Rich Dad Poor Dad");
        lib.showAvailableBooks();
        lib.showIssuedBooks();
        lib.issueBook(2);
        lib.showAvailableBooks();
        lib.showIssuedBooks();
        lib.returnBook(1);
        lib.showAvailableBooks();
        lib.showIssuedBooks();
    }
}
