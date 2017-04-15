import edu.princeton.cs.algs4.StdOut;



/**
 * Are 2 string circular rotations of each other?
 * 
 */
public class StringCircularRotation{
    private StringCircularRotation(){}
    
    public static void main(String[] args){
        String a = args[0];
        String b = args[1];
        int index = a.indexOf(b.substring(0,1));
        if( b.equals(a.substring(index, a.length()) + a.substring(0, index)) ){
            StdOut.println(a + " and " + b + " are a circular rotation of each other.");
        }else{
            StdOut.println(a + " and " + b + " are NOT a circular rotation of each other.");
        }
    }

}
