package Kratu.company;
class German extends Exception{
    @Override
    public String getMessage(){
        return "Hollo und Tschuss";
    }
    @Override
    public String toString(){
        return "Bitte, Entschuldigung!!";
    }
}
public class C14ExceptionsandErrors {
    public static int camp(int a) throws German{
        if (a == 9){
            throw new German();
        }
        else{
            return 7;
        }
    }
    public static void main(String[] args){
        int a = 0;
        while (true){
            try{
                camp(a);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                System.out.println(e.toString());
                //System.out.println(e);
                break;
            }
            finally{
                System.out.println("I am Your Daddy!");
                a++;
            }
        }
    }
}
