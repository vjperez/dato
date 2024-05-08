package main;

import interfases.hashKey;
import interfases.viMap;
import estructura_dato.viHashMap;

public class viHashMapTest{
    public static void main(String[] args){
        final int howManyLists = 7;
        hashKey<Integer> function = (key) ->  { return key % howManyLists; };
        
        viMap<Integer, Integer> mapeo = new viHashMap<Integer,Integer> ( howManyLists, function);
    
        System.out.println("hashTable:separate addressing: Integer");
        System.out.println( mapeo );

    
        mapeo.put(703, 89);
        System.out.println(  "\nput 703, 89" );
        System.out.println( mapeo );

        mapeo.put(70, 25);
        System.out.println(  "\nput 70, 25" );
        System.out.println( mapeo );

        mapeo.put(73, 15);
        System.out.println(  "\nput 73, 15" );
        System.out.println( mapeo );

        mapeo.put(706, 4);
        System.out.println(  "\nput 706, 4" );
        System.out.println( mapeo );        
    }
}