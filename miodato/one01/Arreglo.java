package one01;

/**
 * static functions to sort array using bubble sort and insertion sort,  
 * shift, shuffle and to remove duplicates from an already sorted array
 * 
 */
 
public class Arreglo{
    private Arreglo(){ }
    
    
/** Bubble sorts an array of Strings
 * @param String[]
 */ 
    public static void undeSort(String[] array){
        for(int a = 0; a < -1 + array.length; a++){
            for(int b = -2 + array.length; b >= a; b--){
                if(array[b].compareTo(array[b+1]) > 0){
                    String t= array[b];  array[b]= array[b+1];  array[b+1]= t;
                }
            }
        }
    }
    
    
    
    
/**   Shifts 1 position to the RIGHT every string char from index a
 *    to (bigger or equal) index b, both inclusive.
 *    @param String[]
 *    @param int a - lower index
 *    @param int b - higher index
 *    The caller should save array[b+1] before calling this function
 *    and of course make sure index range a, a+1, ... b, b+1 is a 
 *    valid range.
 */
    public static void shiftRight(String[] array, int a, int b){
        assert(a >= 0): "a can not be negative.";   assert(b+1 < array.length ): "b is out of bounds.";
        int index = b;
        while(index >= a){
            array[index + 1] = array[index];
            index--;
        }
    }
    
    
    
    
/**   Shifts 1 position to the LEFT every string char from index a
 *    to (bigger or equal) index b, both inclusive.
 *    @param String[]
 *    @param int a - lower index
 *    @param int b - higher index
 *    The caller should save array[a-1] before calling this function
 *    and of course make sure index range a-1, a, a+1, ... b, b is a 
 *    valid range.
 */   
    public static void shiftLeft(String[] array, int a, int b){
        assert(a-1 >= 0): "a must be at least 1.";   assert(b < array.length ): "b is out of bounds.";
        int index = a;
        while(index <= b){
            array[index - 1] = array[index];
            index++;
        }
    }
    
    
    
    
/**
 *    Returns an array with 2 integers, indicating where a string must be inserted in order 
 *    to keep array sorted.
 *    @param String array that must be SORTED from index "first" to "last", both inclusive. 
 *    @param a String to be inserted into the String array.
 *    @param int a - lower index
 *    @param int b - higher index
 * 
 *    @return int[] result with the following meaning:
 *    { 0,  index} means "word" IS already found at "index= mid"
 *    {-1,  index} means "word" SHOULD BE placed before "index" to keep array SORTED
 *    { 1,  index} means "word" SHOULD BE placed after  "index" to keep array SORTED
 *   
 *    Why is result array, in scope outsite this function ?? static scope ?
 */   
    public static int[] placementOf(String word, String[] words, int first, int last){
        assert(first >= 0):"first must be non negative.";  assert(last < words.length):"last is out of bounds.";
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
    
    
    
/** Sorts an array of Strings using "insertion after shifting" into an already sorted portion.
 * @param String[]
 */     
    public static void insertionSort(String[] words){
        int first = 0, last = 0, indexAfterLast = 1;
        while(indexAfterLast < words.length){
            String savedValue = words[indexAfterLast];
            int[] where = placementOf(savedValue, words, first, last);
            int flag = where[0]; 
            int index = where[1]; 
            if(flag == 1) index++; // a shift Right from index results in an insert before value at index. Add 1 to insert AFTER value at index
            shiftRight(words, index, last);
            words[index] = savedValue;
            
            last++; 
            indexAfterLast++;
        }
    }
    
    
/** Shuffles an array of Strings using Math.random.
 * @param String[]
 */     
    public static void shuffle(String[] words){
        int howMany = words.length;
        int i = 0;
        while(i < howMany){
            int index01 = (int)(words.length * Math.random()); 
            int index02 = (int)(words.length * Math.random()); 
            String t = words[index01];  words[index01]= words[index02];  words[index02] = t;
            i++;
        }
    }
    
    
    
/**   Removes ALL duplicates from an already SORTED array.
 *    Makes a new copy of the array without duplicates.
 *    Elements are removed by shifting left, but only 1 by 1.
 *    @param String[] - array to remove duplicates from
 *    improvements 
 *    option 1) shift by an amount greater than 1 when needed (avoids SOME unnecesary shifting)
 *    option 2) dont shift at all, just get location info of repeated elements on first transversal
 *    			 then copy elements not repeated when doing a second transversal.
 *    option 3) can option 2 be done with only 1 transversal ?  I think so ;)
 */   
    public static String[] removeDuplicate(String[] words){
		int leftIndex = 0, rightIndex = 1, realLength = words.length;
		while(rightIndex < realLength){
			while(words[leftIndex].equals(words[rightIndex])){ 
				shiftLeft(words, 1 + rightIndex, -1 + realLength);
				realLength--;
				if(!(rightIndex < realLength)) break; // when the last 2 elements are the same, there is nothing to shift left, and realLenght gets reduced, so the element at rightIndex is already out of range beacause rightIndex equals realLenght.
			}
			rightIndex++;
			leftIndex++;	
		}
		// copy if necessary and return	
		// this should be on a separate function
		if(realLength < words.length){
			String[] newWords = new String[realLength];
			for(int i = 0; i < realLength; i++){
				newWords[i] = words[i];
			}
			return newWords;
		}else{
			return words;
		}
	}
	
    
    
    
    // public static void analyzeArray(String[] words){} 
    // Is it sorted? Where are the duplicates?    
	
	
        
}
