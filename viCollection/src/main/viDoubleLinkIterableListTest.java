package main;

import estructura_dato.viDoubleLinkIterableList;
import interfases.viList;


public class viDoubleLinkIterableListTest{
    public static void main(String[] args){
        viList <String> lista = new viDoubleLinkIterableList<String> ();
        System.out.println("lista double link iterable: String");
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
        
        lista.remove("cheo");
        System.out.println( "\nremove cheo ..." );
        System.out.println(  "\t"  + lista );
        
        lista.remove("Victor");
        System.out.println( "\nremove Victor ..." );
        System.out.println(  "\t"  + lista );

        //lista.set(1,"tita");  out of bound exception
        lista.set(0,"tita");        
        System.out.println( "\nreplace rosa, set(0, tita) ..." );
        System.out.println( "\t" + lista );
        
        lista.remove("tita");
        System.out.println( "\nremove (tita) ..." );
        System.out.println( "\t" + lista );        
  
    }

    public static void toUpper( viList<String> list){
        for(int n = 0; n < list.size(); n++){
            String firstLetterToUpper = String.valueOf( list.get(n).charAt(0) ).toUpperCase();
            String otherLetters = list.get(n).substring(1);
            list.set( n,  firstLetterToUpper + otherLetters  ) ;
        }
    }

}