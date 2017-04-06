/*
 * Recibe un arg entero como arg[0]
 * y devuelve un string que representa el valor binario 
 * si el valor dado es un entero no negativo y
 * menor o igual que Integer.Max_Value
 */

import edu.princeton.cs.algs4.StdOut;

class Nueve{
	//works for positive integers and zero
	public static String toBinaryString(int n){
		String binaryString = "";
		do{
			binaryString = Integer.toString(n % 2) + binaryString;
			n = n / 2;
		}while(n > 0);
		return binaryString;
	}
	
	
	//returns integral part of log base 2
	//works for positive integers, not with zero ; log (0) not defined 
	public static int log(int n){
		int logIntegerPart = 0; // log(1) = 0
		while(n > 1){
			logIntegerPart++;
			n = n / 2;
		}
		return logIntegerPart;
	}
	
	
	public static void main(String[] args){
		try{
			if(Integer.parseInt(args[0]) < 0){
				StdOut.println("Not giving binary strings for negative numbers.");
			}else{ 
				StdOut.println("Mi representacion binaria de " + args[0] + " es " + toBinaryString(Integer.parseInt(args[0])) );
				StdOut.println("Representacion binaria de " + args[0] + " usando parseInt(String) y toBinaryString(int) es " + Integer.toBinaryString(Integer.parseInt(args[0])) );
                if(Integer.parseInt(args[0]) >= 1) {
                    StdOut.println("Parte integral del log base 2 de " + args[0] + " es " + log(Integer.parseInt(args[0])) + ".");
                }
			}
		}catch(NumberFormatException e){
			StdOut.println("No se pudo parsear " + args[0] + " a un numero entero no negativo.");
			StdOut.println("Quiza " + args[0] + " es mayor que " + Integer.MAX_VALUE + ", menor que "+ Integer.MIN_VALUE + " o quiza incluiste el punto decimal.");
		}catch(ArrayIndexOutOfBoundsException e){
			StdOut.println("Este programa necesita un argumento en el command line.");
		}	
	}
}
