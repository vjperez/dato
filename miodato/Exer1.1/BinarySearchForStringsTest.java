/*
 * To run use the name of a text file containing strings 
 * as your first command line argument.
 * Use a string a second command line argument.
 * 
 * The programs indicates in what index is located the string
 * passed as the second argument, or informs the user that the 
 * string is not present in the text file.
 * 
 * Binary search makes sense only for sorted arrays.
 */

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearchForStringsTest{
    
    // no objects of these class
    private BinarySearchForStringsTest() { }
    
    public static void main(String[] args){
        In inputStream = new In(args[0]);
        String[] names = inputStream.readAllStrings();
        Arrays.sort(names);
        
        StdOut.println("Sorted names from " + args[0] + " :");
        for(int a = 0; a < names.length; a++){
            StdOut.print(names[a] + " ");
        }
        StdOut.println("");
        
        String person = args[1];
        
        StdOut.println("Searching for " + person + ":");
        int index = BinarySearchForStrings.indexOf(names, person);
        if(index > -1) StdOut.println(person + " found at index " + index + ".");
        else StdOut.println(person + " not found.");
        
        StdOut.println("Searching for " + person + ":");
        index = BinarySearchForStrings.recursiveIndexOf(names, person, 0, -1 + names.length);
        if(index > -1) StdOut.println(person + " found at index " + index + ".");
        else StdOut.println(person + " not found.");        
    }
}



