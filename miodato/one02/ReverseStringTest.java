import edu.princeton.cs.algs4.StdOut;

public class ReverseStringTest{
private ReverseStringTest(){}

    public static void main(String[] args){
        String strToReverse = args[0];
    
        StdOut.println("string : " + strToReverse);
        StdOut.println("reversed string : " + ReverseString.reverse(strToReverse));
        StdOut.println("original string : " + strToReverse);
    }
}
