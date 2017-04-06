/*
 * static functions to sort array using bubble sort and insertion sort,  
 * shift, shuffle and to remove duplicates from an already sorted array
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
    public static void shiftRight(String[] array, int a, int b){
        int index = b;
        while(index >= a){
            array[index + 1] = array[index];
            index--;
        }
    }
    
    
    
    
    // Shifts 1 position to the LEFT every string from index a
    // to index b, both inclusive
    // The caller should save array[a-1] before calling this function
    // and of course make sure index range a-1, a, a+1, ... b, b is a 
    // valid range.
    public static void shiftLeft(String[] array, int a, int b){
        int index = a;
        while(index <= b){
            array[index - 1] = array[index];
            index++;
        }
    }
    
    
    
    
    // Receives a String array that must be SORTED from index "first" to "last", both inclusive. 
    // It also receives a String as a parameter.
    // Returns an array with 2 integers, indicating where string must be inserted in order 
    // to keep array sorted.
    // A result of:
    // { 0,  index} means "word" IS already found at "index= mid"
    // {-1,  index} means "word" SHOULD BE placed before "index" to keep array SORTED
    // { 1,  index} means "word" SHOULD BE placed after  "index" to keep array SORTED
    
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
        int first = 0, last = 0, indexAfterLast = 1;
        while(indexAfterLast < words.length){
            String savedValue = words[indexAfterLast];
            int[] where = placementOf(savedValue, words, first, last);
            int flag = where[0]; 
            int index = where[1]; 
            if(flag == 1) index++; // a shift Right from index results in an insert before index. Add 1 to insert AFTER
            shiftRight(words, index, last);
            words[index] = savedValue;
            
            last++; 
            indexAfterLast++;
        }
    }
    
    
    
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
    
    
    
    // removes ALL duplicates from an already SORTED array
    // makes a new copy of the array using only elements
    // that are not repeated. Array length will be reduced
    // if duplicates are found. Elements are shifted left but only 1 by 1.
    
    // improvements 
    // option 1) shift by an amount greater than 1 when needed (avoids SOME unnecesary shifting)
    // option 2) dont shift at all, just get location info of repeated elements on first transversal
    // 			 then copy elements not repeated when doing a second transversal.
    // option 3) can option 2 be done with only 1 transversal ?  I think so ;)
    
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
	
	
	
        
}
