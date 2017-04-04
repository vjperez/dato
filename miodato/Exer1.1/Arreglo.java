/*
 * static functions to sort array, sort array removing duplicates and  
 * to remove duplicates from an already sorted array
 * 
 */
public class Arreglo{
    // bubble sort 
    public static void undeSort(String[] array){
        for(int a = 0; a < -1 + array.length; a++){
            for(int b = -2 + array.length; b >= a; b--){
                if(array[b].compareTo(array[b+1]) > 0){
                    String t= array[b];  array[b]= array[b+1];  array[b+1]= t;
                }
            }
        }
    //return array;
    }
    
    
    
    
    // Shifts 1 position to the RIGHT every string from index a
    // to index b, both inclusive
    // The caller should save array[b+1] before calling this function
    // and of course make sure index range a, a+1, ... b, b+1 is a 
    // valid range.
    public static void shift(String[] array, int a, int b){
        int index = b;
        while(index >= a){
            array[index + 1] = array[index];
            index--;
        }
    }
    
    
    
    
    // Receives a String array that must be SORTED from index "first" to "last", both inclusive. 
    // It also receives a String as a parameter.
    // returns an array with 2 integers:
    // A result of:
    // { 0,  index} means required String WAS found at "index"
    // {-1,  index} means required String WOULD BE placed before "index" to keep array SORTED
    // { 1,  index} means required String WOULD BE placed after  "index" to keep array SORTED
    
    // Why is result array, in scope outsite this function ?? static scope ?
    
    public static int[] placementOf(String word, String[] words, int first, int last){
        int mid;
        int[] result = new int[2];
        while(first <= last){
            mid = (first + last) / 2;
            if(word.compareTo(words[mid]) > 0){
                first = mid + 1;
                result[0] =  1; result[1] = mid;
            }else if(word.compareTo(words[mid]) < 0){
                last = mid - 1;
                result[0] = -1; result[1] = mid;
            }else{
                result[0] = 0; result[1] = mid;
                return result;
            }
        }
        return result;
    }
    
    
    
    
    public static void insertionSort(String[] words){
        int first = 0, last = 0, indexOutOfRange = 1;
        while(indexOutOfRange < words.length){
            String savedValue = words[indexOutOfRange];
            int[] where = placementOf(savedValue, words, first, last);
            int flag = where[0]; int index = where[1]; 
            if(flag == 0 || flag == 1) index++; // 0 means value is a duplicate, 1 means insert AFTER, in either case insert after
            shift(words, index, last);
            words[index] = savedValue;
            
            last++; 
            indexOutOfRange++;
        }
    }
    
    
    
    public static void shuffle(String[] words){
        int howMany = words.length / 2;
        int i = 0;
        while(i < howMany){
            int index01 = (int)(words.length * Math.random()); 
            int index02 = (int)(words.length * Math.random()); 
            String t = words[index01];  words[index01]= words[index02];  words[index02] = t;
            i++;
        }
    }    
}
