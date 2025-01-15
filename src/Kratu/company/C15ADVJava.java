package Kratu.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
/**
 * This is the JavaFile for the demonstration of  Many ADVANCE JAVA concepts.
 * @use <p>Collections Methods (ArrayList) in AL, Date Class Methods as DT, Calendar Class Methods as CAL, LocalDateTime and DateTimeFormatter Methods as MDT, File and FileWriter Methods as FILE.</p>
 * <i>There are Demonstrations of Anonymous Class and Lambda Methods as well.</i>
 *@Author: Kratu Gautam
 * @Version: 1
 * @Since: 2025
 * @See: <a href="https://docs.oracle.com/en/java/">More Java Documentation!</a>
 */

interface  dom{
    void meth(int a, int b);
}
/*dom is the interface which is plays a role in main method.
 * @use For Anonymous Class and Lambda Function. with an abstract method.
 */
/**
*<h1>Here is our Main Class named as C15ADVJava.java.</h1>
 */
public class C15ADVJava {
    /**AL Method is the Method with only Implementation of ArrayList, which you can refer and apply to
     * <i>LinkedList, ArrayDeque and Hashing Collections like HashMap, LinkedHashMap, HashTable, HashSet.</i>
     * @return void
     */
    public static void AL(){
        ArrayList<Integer> l1 = new ArrayList<>(2);
        ArrayList l2 = new ArrayList();
        l2.add("adsfjl;l");
        l2.add(78);
        l2.add('a');
        l1.add(6);
        l1.add(0,6);
        System.out.println(l1.indexOf(6));
        System.out.println(l1.lastIndexOf(6));
        l1.addAll(0,l2);
        l2.clear();
        l1.set(3,7);
        ArrayList l3 = (ArrayList)l1.clone();
        System.out.println(l3);
    }
    /**DT Method is the Implementation of Date Class whose almost Every Methods got Deprecated. It is Only supported with older applications.
     * @return void
     * @Deprecated Use MDT method Instead.
     */
    @Deprecated
    public static void DT(){
        Date d = new Date();
        System.out.println(d);
        System.out.println(d.getTime());
        System.out.println(d.getDate());
        System.out.println(d.getYear());
        System.out.println(d.getSeconds());
        System.out.println(d.getTimezoneOffset());
    }
    /**CAL Method includes Methods like getTimeZone().getID(), getInstance method of Initialization and getCalendarType.
     * <h4>All mentioned methods are called from 2 different locations.</h4>
     * @return Void
     */
    public static void CAL(){
        Calendar NY = Calendar.getInstance(TimeZone.getTimeZone("America/New_York"));
        Calendar IN = Calendar.getInstance();
        System.out.println(NY.getCalendarType());
        System.out.println(NY.getTimeZone().getID());
        System.out.println(IN.getTimeZone().getID());
    }
    /**MDT Method includes methods of 2 different and newer classes named LocalDateTime and DateTimeFormatter.
     * <b>Upgradation of Deprecated Method DT.</b>
     * @return Void
     */
    public static void MDT() {
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter df2 = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.println(dt.format(df1));
        System.out.println(dt.format(df2));
    }
    /**FILE Method has demonstration of File Handling like Creation, Deletion, Reading and Writing of File Data.
     * @return Void
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void FILE(){
        File mf = new File("xy.text");
        try{
            mf.createNewFile();
            FileWriter yf = new FileWriter("xy.text");
            yf.write(" Java is a high-level, class-based, object-oriented programming language that is designed to have as\n few implementation dependencies as possible. It is a general-purpose programming language intended\n to let programmers write once, run anywhere meaning that compiled Java code can run on all platforms\n that support Java without the need to recompile. Java applications are typically compiled to bytecode\n that can run on any Java virtual machine (JVM) regardless of the underlying computer architecture.\n The syntax of Java is similar to C and C++, but has fewer low-level facilities than either of them.\n The Java runtime provides dynamic capabilities (such as reflection and runtime code modification)\n that are typically not available in traditional compiled languages.");
            yf.close();
        }
        catch(IOException e){
            System.out.println("unable to create file, sorry dumbass!!");
            e.printStackTrace();
        }
        try{
        Scanner sc = new Scanner(new File("xy.text"));
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            System.out.println(line);
        }
        sc.close();}
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        mf.delete();
    }

    /**Main method is the calling point of other methods.
     * <b>It includes use of Anonymous Class and Lambda Function.</b>
     * @param args
     */
    public static void main(String[] args) {
        AL();
        System.out.println("");
        DT();
        System.out.println("");
        CAL();
        System.out.println("");
        MDT();
        System.out.println("");
        dom obj1 = new dom() {
            @Override
            public void meth(int a,int b) {
                System.out.println(a*b);
            }
        };
        dom obj2 = (a,b) -> {
            System.out.println(a*b);
        };
        obj1.meth(9,10);
        obj2.meth(5,6);
        System.out.println("");
        FILE();
    }
}

