/**
 * Usando Scanner para input.
 * 
 * Este programa suma todos los numeros q esten en std input.
 * Std input puede venir de la pantalla o de un file como
 * TestingStdIn00.dato
 * Si el el input viene de pantalla, CTL D termina el loop.
 * 
 * Los byte van desde 2 a la 7 menos 1 (127) hasta
 * negativo 2 a la 7 (-128). Los primeros file de datos demuestran overflow.
 * El ultimo demuestra la suma sin overflow.
 */

import java.util.Scanner;

class TestingScannerStdInput{
	public static void main(String[] args){
		Scanner scanner = new Scanner(new java.io.BufferedInputStream(System.in));
		byte total = 0;
		do{
			total  +=  scanner.nextByte();
		}while(scanner.hasNext());
		System.out.println("El total es " + total + "."); 
	}
}
