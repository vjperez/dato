package main;

import estructura_dato.viDoubleLinkList;
import interfases.viList;

public class viDoubleLinkListTest{
    public static void main(String[] args){
        viList <String> lista = new viDoubleLinkList<String> ();
        System.out.println("lista double link: String");
        System.out.println(  "\t"  + lista );


        lista.add("victor");
        toUpper(lista);
        System.out.println(  "\nadding victor,  toUpper()..." );
        System.out.println(  "\t"  + lista );

        lista.add("cheo");
        System.out.println(  "\nadding cheo..." );      
        System.out.println(  "\t"  + lista );

        lista.add("rosa");
        System.out.println(  "\nadding rosa..." );
        System.out.println(  "\t"  + lista );        
        
        System.out.println( "\nremove cheo ..." );
        lista.remove("cheo");
        System.out.println(  "\t"  + lista );
        
        System.out.println( "\nremove Victor ..." );
        lista.remove("Victor");
        System.out.println(  "\t"  + lista );
        
        System.out.println( "\nreplace rosa, set(0, tita) ..." );
        //lista.set(1,"tita");  out of bound exception
        lista.set(0,"tita");
        System.out.println( "\t" + lista );
        
        System.out.println( "\nremove (tita) ..." );
        lista.remove("tita");
        System.out.println( "\t" + lista );        


        System.out.println("\n\nlistaInt double link: Integer");
        viList <Integer> listaInt = new viDoubleLinkList<Integer> ();
        System.out.println( "\t" + listaInt );
        //if int is used, add(int) is implicitly casted to add(Integer), 
        //with remove(int) that is a problem and could produce outOfBoundException, since remove(E elm)
        //is interpreted as remove(int) where int is the index
        Integer n = 1024;  
        listaInt.add(n);
        System.out.println(  "\nadd 1024..." );
        System.out.println(  "\t"  + listaInt );
        

        System.out.println( "\nremove(" + n + ")..." );
        //make sure class Integer is used as node element, remove(Integer element),
        //otherwise remove(int) is used, where int is an index 
        listaInt.remove(n);
        System.out.println(  "\t"  + listaInt );

        //firstIndex() and lastIndex() has no conflict between int vs Integer
        //it is better to stick with class Integer for node elements
        //int was used here to test it!
        int a = 22, b = 33, c = 40, d = 33; 
        Integer e = 55;
        Integer f = 99;
        listaInt.add(a); listaInt.add(b); listaInt.add(c); listaInt.add(d); listaInt.add(e); listaInt.add(f);
        System.out.println("\nlistaInt double link : Integer \nadd five numbers..");
        System.out.println(  "\t"  + listaInt );
        System.out.println("first index of 33: " + listaInt.firstIndex(33) + "\tlast index of 33: " + listaInt.lastIndex(33) );
        System.out.println("first : " + listaInt.first() + "\tlast : " + listaInt.last() );
        System.out.println("contains 22 : " + listaInt.contains(22) + "\tcontains 40: " + listaInt.contains(40) + "\tcontains 99: " + listaInt.contains(99) );
        
        System.out.println(  "\nadd 33, at index 0, then add 33 ..." );
        listaInt.add(0, 33);  
        listaInt.add(33);
        System.out.println(  "\t"  + listaInt );
        System.out.println("first index of 33: " + listaInt.firstIndex(33) + "\tlast index of 33: " + listaInt.lastIndex(33) );
        System.out.println("first : " + listaInt.first() + "\tlast : " + listaInt.last() );
        System.out.println("contains 22 : " + listaInt.contains(22) + "\tcontains 40: " + listaInt.contains(40) + "\tcontains 99: " + listaInt.contains(99) );        

        System.out.println( "\nremove All 33's ..." );
        int many = listaInt.removeAll( b );
        System.out.println("removed " + many + " instances of " + b + " ...");
        System.out.println(  "\t"  + listaInt );
        System.out.println( "clear it..." );
        listaInt.clear();
        System.out.println(  "\t"  + listaInt );

        System.out.println( "\nremoveAll() after single add of " + f + " ..." );
        listaInt.add(f);
        System.out.println(  "\t"  + listaInt );
        many = listaInt.removeAll(f);
        System.out.println("removed " + many + " instances of " + f + " ...");
        System.out.println(  "\t"  + listaInt );


        //print with Iterator
    }

    public static void toUpper( viList<String> list){
        for(int n = 0; n < list.size(); n++){
            String firstLetterToUpper = String.valueOf( list.get(n).charAt(0) ).toUpperCase();
            String otherLetters = list.get(n).substring(1);
            list.set( n,  firstLetterToUpper + otherLetters  ) ;
        }
    }
}