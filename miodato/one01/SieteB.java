/*
 *
 * Should print 999/2 * 1000
 * that is 
 * 1 + 2 + 3 ... 999 
 */

import edu.princeton.cs.algs4.StdOut;

class SieteB{
	public static void main(String[] args){
		int sum  = 0;
		for(int i  =  1; i < 1000; i++ ){
				for(int j = 0; j < i; j++ ){
					sum++;
				}
		}
		StdOut.println(sum);
		
		
		// 1.8
		StdOut.println('a');
		StdOut.println('a' +  0);
		StdOut.println('a' +  1);
		StdOut.println('a' + 'b');
		StdOut.println((char)('a' +  1));
	}
}
