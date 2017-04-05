/*
 * To run use the name of a text file containing strings (names) 
 * as your first command line argument.  There must be 1 name per line. 
 * For example genteListaBlanca.txt
 * 
 * Use redirection in the command line ( < file2.txt ) to input the names from a second text file
 * For example genteIntentando.txt
 * 
 * The program indicates who in the second file is also present on the first (using + as second command line argument).
 * The program indicates who in the second file is NOT present on the first (using - as second command line argument). 
 *
 * The first file can be viewed as people with proper authorization (for whatever!),
 * and the second file can be vizualized as people trying to get access, or requesting whatever.
 *
 *
 * Binary search makes sense only for sorted arrays.
 */

import java.util.Arrays;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class BinarySearchForStringsTest02{
    
    // no objects of these class
    private BinarySearchForStringsTest02() { }
    
    public static void main(String[] args){
        In inputStream = new In(args[0]);
        String[] authorizedPeople = inputStream.readAllLines();
        Arrays.sort(authorizedPeople);
        
        StdOut.println("According to " + args[0] + " the authorized people are:");
        for(int a = 0; a < authorizedPeople.length; a++){
            StdOut.print(authorizedPeople[a] + " : ");
        }
        StdOut.println("");
        
        if(args[1].equals("+")){
            StdOut.println("\nAllowing access to:");
            int requesting = 0, allowed = 0;
            while(StdIn.hasNextLine()){
                String personRequesting = StdIn.readLine();
                requesting++;
                if(BinarySearchForStrings.recursiveIndexOf(personRequesting, authorizedPeople, 0, -1+authorizedPeople.length) > -1){
                    allowed++;
                    StdOut.println(personRequesting + " is allowed.");
                }
            }
            StdOut.println(requesting + " wanted access, " + allowed + " where allowed.");
        }
        if(args[1].equals("-")){
            StdOut.println("\nNot Allowing access to:");
            int requesting = 0, notAllowed = 0;
            while(StdIn.hasNextLine()){
                String personRequesting = StdIn.readLine();
                requesting++;
                if(BinarySearchForStrings.recursiveIndexOf(personRequesting, authorizedPeople, 0, -1+authorizedPeople.length) == -1){
                    notAllowed++;
                    StdOut.println(personRequesting + " is NOT allowed.");
                }
            }
            StdOut.println(requesting + " wanted access, " + notAllowed + " where NOT allowed.");
        }       
       
        
    }
}



