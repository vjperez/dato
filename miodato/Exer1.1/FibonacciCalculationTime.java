/*
 *  Working with the calculation time of the Fibonacci series
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
        int f = Integer.parseInt(args[0]);
        
        fibonacciCalculationTime.setTimeA();
        long result = F(f);
        fibonacciCalculationTime.setTimeB();
        
        
        //StdOut.printf("%.6f\n", 1.0/7.0);
        StdOut.printf("Fibonacci " + args[0] + " = " + "%,d\n",result );
        StdOut.println("Calculation took " + fibonacciCalculationTime.getMilliSecondsDiference() + " milliseconds.");
    }
}
