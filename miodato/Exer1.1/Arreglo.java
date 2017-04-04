/*
 * static functions to sort array, sort array removing duplicates and  
 * to remove duplicates from an already sorted array
 * 
 */
public class Arreglo{
    // 
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
}
