/*
 *  Working with the calculation time of the Fibonacci series
 * 
 */

import java.util.Arrays;

class FibonacciWithArray{
    
    static{
		FibonacciWithArray.fibonacciArray = new long[100]; 
		Arrays.fill(FibonacciWithArray.fibonacciArray, -1);
		FibonacciWithArray.fibonacciArray[0] = 0;  
		FibonacciWithArray.fibonacciArray[1] = 1;  
	}
	
	//calculates Fibonacci using array with capacity to store first 100 fibonacci values
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
    

    
    private static long[] fibonacciArray;
}
