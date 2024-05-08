package main;

import interfases.hashKey;
import interfases.viMap;
import estructura_dato.viHashMap;

public class viHashMapTest{
    public static void main(String[] args){
        final int howManyLists = 3;
        hashKey<Integer> function = (key) ->  { return key % howManyLists; };
        
        viMap<Integer, Integer> mapeo = new viHashMap<Integer,Integer> ( howManyLists, function);
    
        System.out.println("hashTable:separate addressing: Integer");
        System.out.println( mapeo );

        Integer v;
        v = mapeo.put(30, 89);
        System.out.println(  "\n put()  key:value   30:89     replaced value:" + v );
        System.out.println( mapeo );

        v = mapeo.put(32, 25);
        System.out.println(  "\n put()  key:value   32:25     replaced value:" + v );
        System.out.println( mapeo );

        v = mapeo.put(30, 15);
        System.out.println(  "\n put()  key:value   30:15     replaced value:" + v + "   same key, diferent value!");
        System.out.println( mapeo );

        v = mapeo.put(90, 88);
        System.out.println(  "\n put()  key:value   90:88     replaced value:" + v );
        System.out.println( mapeo );

        v = mapeo.put(120, 42);
        System.out.println(  "\n put()  key:value   120:42     replaced value:" + v );
        System.out.println( mapeo );

        v = mapeo.put(30, 15);
        System.out.println(  "\n put()  key:value   30:15     replaced value:" + v + "   same key and same value!");
        System.out.println( mapeo );

        v = mapeo.put(121, 4);
        System.out.println(  "\n put()  key:value   121:4     replaced value:" + v );
        System.out.println( mapeo ); 

        v = mapeo.get(30);
        System.out.println(  "\n:get()  key:30     value:" + v );
        System.out.println( mapeo ); 

        v = mapeo.get(32);
        System.out.println(  "\n:get()  key:32     value:" + v );
        System.out.println( mapeo ); 

        v = mapeo.get(99);
        System.out.println(  "\n:get()  key:99     value:" + v );
        System.out.println( mapeo );

        v = mapeo.get(120);
        System.out.println(  "\n:get()  key:120     value:" + v );
        System.out.println( mapeo );

        v = mapeo.get(90);
        System.out.println(  "\n:get()  key:90     value:" + v );
        System.out.println( mapeo );        

        v = mapeo.remove(30);
        System.out.println(  "\n:remove()  key:30     removed value:" + v );
        System.out.println( mapeo ); 

        v = mapeo.remove(32);
        System.out.println(  "\n:remove()  key:32     removed value:" + v );
        System.out.println( mapeo ); 

        v = mapeo.remove(99);
        System.out.println(  "\n:remove()  key:99     removed value:" + v );
        System.out.println( mapeo );
    }
}