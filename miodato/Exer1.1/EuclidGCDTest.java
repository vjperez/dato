/*
 *  Testing a class that computes greatest common divisor
 *  of any 2 nonnegative integers.
 * 
 *  The two nonnegatives integers are received as command line arguments.
 * 
 */
 
import edu.princeton.cs.algs4.StdOut;

public class EuclidGCDTest{

public static void main(String[] args){
    try{
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println("computing greatest common divisor of " + a + " and " + b + ".");
        StdOut.println("GCD is " + EuclidGCD.greatestCommonDivisor(a, b) + ".");
    }catch(NumberFormatException e){
        StdOut.println("Command line arguments must be any 2 nonnegative integers.");
    }catch(ArrayIndexOutOfBoundsException e){
        StdOut.println("This program needs 2 command line arguments.");
    }
}

}
