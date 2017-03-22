/*
 * Este programa corre usando 3 argumentos enteros
 * y escoge el mayor de los 3 primeros argumentos.
 * 
 */

class TestingCommandArgs{
	public static void main(String[] args){
		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		int c = Integer.parseInt(args[2]);
		
		int greatest = a;
		if (b > greatest) greatest = b;
		if (c > greatest) greatest = c;
		System.out.println("El mayor es " + greatest + "."); 
	}
}
