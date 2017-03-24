/*
 *  Working with the calculation time of the Fibonacci series
 *  Calculates fibonacci numbers from "a" to "b"
 *  "a" and "b" are received as command line arguments
 */

import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

class FibonacciCalculationTime{
    
    public FibonacciCalculationTime(){
		//fibonacciArray = new long[100];
		Arrays.fill(fibonacciArray, -1);
		fibonacciArray[0] = 0;  
		fibonacciArray[1] = 1;  
	}
	
	//calculates Fibonacci storing values in array
    public static long Fib(int f){
        if(f == 0) return fibonacciArray[0];
        if(f == 1) return fibonacciArray[1];
        
        long addA, addB;
        if(fibonacciArray[f-2] == -1){
			addA = Fib(f-2);
		}else{
			addA = fibonacciArray[f-2]; 
		}
		
		
        if(fibonacciArray[f-1] == -1){
			addB = Fib(f-1);
		}else{
			addB = fibonacciArray[f-1]; 
		}
		  
		  
		fibonacciArray[f] = addA + addB;  
        return addA + addB;
    }
    
    //calculates Fibonacci without storing values in array
    public static long F(int f){
        if(f == 0) return 0;
        if(f == 1) return 1;
        return F(f-2) + F(f-1);
    }
    
    
    public static void main(String[] args){
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        TimeInterval fibonacciCalculationTime = new TimeInterval();
        
        for(int f = a; f < b; f++){
            fibonacciCalculationTime.setTimeA();
            long result = Fib(f);
            fibonacciCalculationTime.setTimeB();
        
            StdOut.printf("Fibonacci " + f + " = " + "%,d\n",result );
            StdOut.println("Calculation took " + fibonacciCalculationTime + "\n");
        }
    }
    
    private static long[] fibonacciArray = new long[100];
}
