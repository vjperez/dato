/*
 *  Working with Fibonacci series
 *  
 */

import edu.princeton.cs.algs4.StdOut;

class DiezYNueve{
    
    public static long F(int f){
        //StdOut.println("Need F(" + f + ").");
        if(f == 0) return 0;
        if(f == 1) return 1;
        return F(f-2) + F(f-1);
    }
    

    
    
    public static void main(String[] args){
        StdOut.println("Fibonacci 0 = " + F(0));
        StdOut.println("Fibonacci 1 = " + F(1));
        StdOut.println("Fibonacci 2 = " + F(2));
        StdOut.println("Fibonacci 3 = " + F(3));
        StdOut.println("Fibonacci 4 = " + F(4));
        StdOut.println("Fibonacci 5 = " + F(5));
        StdOut.println("Fibonacci 6 = " + F(6));
        StdOut.println("Fibonacci 7 = " + F(7));
        StdOut.println("Fibonacci 8 = " + F(8));
    }
}
