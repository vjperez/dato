//import edu.princeton.cs.algs4.StdOut;

public class BinarySearchForStrings{
    
    // no objects of these class
    private BinarySearchForStrings() { }
    
    // Receives a String array that must be SORTED from index "first" to "last". 
    // It also receives a String as a parameter.
    // returns index of required String if present between "first" and "last"
    // returns -1 otherwise
    public static int indexOf(String word, String[] words, int first, int last){
        int mid;
        
        while(first <= last){ 
            mid = (first + last) / 2;
            //StdOut.println("first:" + first + " mid:" + mid + " last:" + last);
            if(word.compareTo(words[mid]) > 0){
                first = mid + 1;
            }else if(word.compareTo(words[mid]) < 0){
                last = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }


    public static int recursiveIndexOf(String word, String[] words, int first, int last){
        if(first > last) return -1;
        
        int mid = (first + last) / 2;
        //StdOut.println("first:" + first + " mid:" + mid + " last:" + last);
        if(word.compareTo(words[mid]) > 0) return recursiveIndexOf(word, words, mid+1, last);
        else if(word.compareTo(words[mid]) < 0) return recursiveIndexOf(word, words, first, mid-1);
        else return mid;
    }
}
