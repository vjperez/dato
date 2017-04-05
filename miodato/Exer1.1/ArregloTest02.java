import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ArregloTest02{
    
    // no objects of these class
    private ArregloTest02() { }
    
    public static void main(String[] args){
        In inputStream = new In(args[0]);
        String[] names = inputStream.readAllStrings();
        
        int answer = 1; // any value that makes condition TRUE
        while (answer >= 1 && answer <= 6){
            String name;
            int a, b;
            
            StdOut.println("\n\nStrings from " + args[0] + " :");
            for(int i = 0; i < names.length; i++){
                StdOut.print(i + ":" + names[i] + "  ");
            }
            StdOut.println("");
            
            StdOut.println("Select a function to work on the array.\n1:bubble sort,  2:insertion sort,  3:shiftR,  4:check index for insertion,  5:shuffle,  6:shiftL");
            answer = StdIn.readInt();
            switch(answer){
            case 1:
                Arreglo.undeSort(names);
            break;
            case 2:
                Arreglo.insertionSort(names);
            break;
            case 3:
                StdOut.println("Write index a: ");  
                a = StdIn.readInt(); 
                StdOut.println("write index b: ");  
                b = StdIn.readInt();
                Arreglo.shiftRight(names, a, b);
            break;
            case 4:
                StdOut.println("Write name to check: "); 
                name = StdIn.readString(); 
                StdOut.println("Write index a: ");  
                a = StdIn.readInt(); 
                StdOut.println("Write index b: ");  
                b = StdIn.readInt();
                StdOut.println("Verifying where " + name + " would be inserted to keep array sorted.");
                int[] resultado = Arreglo.placementOf(name, names, a, b);
                if(resultado[0] == 0) StdOut.println(name + " was found at index " + resultado[1] + ", a duplicate could be placed before or after that index to keep array sorted.");
                else if (resultado[0] == 1  ) StdOut.println(name + " was not found, it could be inserted AFTER index "  + resultado[1] + " to keep array sorted.");
                else if (resultado[0] == -1 ) StdOut.println(name + " was not found, it could be inserted BEFORE index " + resultado[1] + " to keep array sorted.");
            break;
            case 5:
                Arreglo.shuffle(names);
            break;
            case 6:
                StdOut.println("Write index a: ");  
                a = StdIn.readInt(); 
                StdOut.println("write index b: ");  
                b = StdIn.readInt();
                Arreglo.shiftLeft(names, a, b);
            break;            
            default:break;
            } //switch
        } //while
   }
}
