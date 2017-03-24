/*
 *  Working with the calculation time of the Fibonacci series
 *  Calculates fibonacci numbers from "a" to "b"
 *  "a" and "b" are received as command line arguments
 */

import edu.princeton.cs.algs4.StdOut;

class FibonacciCalculationTime{
    
    public static long F(int f){
        if(f == 0) return 0;
        if(f == 1) return 1;
        return F(f-2) + F(f-1);
    }
    

    
    
    public static void main(String[] args){
        TimeInterval fibonacciCalculationTime = new TimeInterval();
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        
        for(int f = a; f < b; f++){
            fibonacciCalculationTime.setTimeA();
            long result = F(f);
            fibonacciCalculationTime.setTimeB();
        
            StdOut.printf("Fibonacci " + f + " = " + "%,d\n",result );
            StdOut.println("Calculation took " + fibonacciCalculationTime + "\n");
        }
    }
}
