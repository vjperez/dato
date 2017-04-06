/*
 *  Computes greatest common divisor
 *  of any 2 nonnegative integers
 * 
 */
 
import edu.princeton.cs.algs4.StdOut;

public class EuclidGCD{

public static int greatestCommonDivisor(int a, int b){
    StdOut.println("a= " + a + "  b= " + b);
    
    if(b==0) return a;
    return greatestCommonDivisor(b, a%b);
}

}
