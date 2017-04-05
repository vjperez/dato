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
    // { 0,  index} means required String IS already found at "index"
    // {-1,  index} means required String SHOULD BE placed before "index" to keep array SORTED
    // { 1,  index} means required String SHOULD BE placed after  "index" to keep array SORTED
    
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
            int flag = where[0]; 
            int index = where[1]; 
            if(flag == 0 || flag == 1) index++; // 0 means value is a duplicate, 1 means insert AFTER, in either case insert after
            shiftRight(words, index, last);
            words[index] = savedValue;
            
            last++; 
            indexOutOfRange++;
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
    
    
    
    // remove ALL duplicates from an already SORTED array
    // makes a new array copying elements, array length may be reduced
    public static String[] removeDuplicate(String[] words){
		int leftIndex = 0, rightIndex = 1, duplicates = 0, realLength = words.length - duplicates;
		while(rightIndex < realLength){
			while(words[leftIndex].equals(words[rightIndex])  &&  rightIndex < realLength){ 
				shiftLeft(words, 1 + rightIndex, -1 + realLength);
				duplicates++;
				realLength = words.length - duplicates;
			}
			rightIndex++;
			leftIndex++;	
		}
		if(duplicates > 0){
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
