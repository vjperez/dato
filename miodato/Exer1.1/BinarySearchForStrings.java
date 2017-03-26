
//import edu.princeton.cs.algs4.StdOut;

public class BinarySearchForStrings{
    
    // no objects of these class
    private BinarySearchForStrings() { }
    
    // receives a String array and a String as parameters
    // returns index of required String if present, returns -1 otherwise
    public static int indexOf(String[] words, String word){
        int first = 0;
        int last = -1 + words.length; 
        int mid = (first + last) / 2;
        
        while(first <= last){
            //StdOut.println("first:" + first + " mid:" + mid + " last:" + last);
            if(word.compareTo(words[mid]) > 0){
                first = mid + 1;    mid = (first + last) / 2;
            }else if(word.compareTo(words[mid]) < 0){
                last = mid - 1;    mid = (first + last) / 2;
            }else{
                return mid;
            }
        }
        return -1;
    }
    
    public static int recursiveIndexOf(String[] words, String word, int first, int last){
        if(first > last) return -1;
        
        int mid = (first + last) / 2;
        //StdOut.println("first:" + first + " mid:" + mid + " last:" + last);
        if(word.compareTo(words[mid]) > 0) return recursiveIndexOf(words, word, mid+1, last);
        else if(word.compareTo(words[mid]) < 0) return recursiveIndexOf(words, word, first, mid-1);
        else return mid;
    }
}
