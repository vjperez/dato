/**
 * Usando StdIn y StdOut del paquete de sedgewick.
 * 
 * You need to compile using -classpath pointing
 * to the directory where edu.princeton package is located
 * 
 * To run it use -classpath including both the path to the imports
 * AND the path to the program (even if as usual it is the current directory).
 * java -classpath dir1:dir2:jar1:currentDirectory mainProgramClass
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

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

class TestingStdInStdOut{
	public static void main(String[] args){
		
		byte total = 0;
		do{
			total  +=  StdIn.readByte();
		}while( ! StdIn.isEmpty() );
		
		StdOut.println("El total es " + total + "."); 
	}
}
