/*
 * To run use the name of a text file containing strings (names in nombres.txt)
 * as your first command line argument.
 * Use a string as a second command line argument (a name to verify using nombres.txt).
 * 
 * Testing  Arreglo.undeSort() and Arreglo.placementOf()
 */

//import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class ArregloTest{
    
    // no objects of these class
    private ArregloTest() { }
    
    public static void main(String[] args){
        In inputStream = new In(args[0]);
        String[] names = inputStream.readAllStrings();
        //Arrays.sort(names);
        Arreglo.undeSort(names);
        
        StdOut.println("Sorted strings from " + args[0] + " :");
        for(int a = 0; a < names.length; a++){
            StdOut.print(a + ":" + names[a] + "  ");
        }
        StdOut.println("");
        String person = args[1];
        
        StdOut.println("\nVerifying where " + person + " would be inserted to keep array sorted.");
        int[] resultado = Arreglo.placementOf(person, names, 0, -1 + names.length);
        StdOut.println("{flag:index} = {" +  resultado[0] + ":" + resultado[1] + "}.");
        if(resultado[0] == 0) StdOut.println(person + " was found at index " + resultado[1] + ", a duplicate could be placed before or after that index to keep array sorted.");
        else if (resultado[0] == 1  ) StdOut.println(person + " was not found, it could be inserted AFTER index "  + resultado[1] + " to keep array sorted.");
        else if (resultado[0] == -1 ) StdOut.println(person + " was not found, it could be inserted BEFORE index " + resultado[1] + " to keep array sorted.");
    }
}
