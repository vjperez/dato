/*
 *  Working with the calculation time of the Fibonacci series
 *  Calculates fibonacci numbers from "a" to "b"
 *  "a" and "b" are received as command line arguments
 */

import edu.princeton.cs.algs4.StdOut;

class FibonacciWithArrayTest{
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        TimeInterval fibonacciCalculationTime = new TimeInterval();
        
        StdOut.println("Calculation done using array to save values.");
        for(int f = a; f < b; f++){
            fibonacciCalculationTime.setTimeA();
            long result = FibonacciWithArray.Fib(f);
            fibonacciCalculationTime.setTimeB();
        
            StdOut.printf("Fibonacci " + f + " = " + "%,d\n",result );
            StdOut.println("Calculation took " + fibonacciCalculationTime + "\n");
        }
    }
}
