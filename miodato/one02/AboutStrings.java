import edu.princeton.cs.algs4.StdOut;



/**
 * Tricky string references ?!
 * a goes away to reference "other string", but b stays there
 */
public class AboutStrings{
    private AboutStrings(){}
    
    public static void main(String[] args){
        String a = "victor";
        String b = a;
        StdOut.println("a = " + a + "      b = " + b);
        
        a = "other string...";
        StdOut.println("a = " + a + "      b = " + b);
    }

}
