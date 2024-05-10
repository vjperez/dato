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

        lista.add(0, "evelyn");
        System.out.println(  "\nadding eve at 0..." );
        System.out.println(  "\t"  + lista );  

        lista.add(1, "luisa");
        System.out.println(  "\nadding luisa at 1..." );
        System.out.println(  "\t"  + lista );   

        System.out.println(  "\nfirst.." );
        System.out.println(  "\t"  + lista.first() );

        System.out.println(  "\nlast..." );
        System.out.println(  "\t"  + lista.last() );  
        
        lista.remove("cheo");
        System.out.println( "\nremove cheo ..." );
        System.out.println(  "\t"  + lista );
        
        lista.remove(2);
        System.out.println( "\nremove index=2 ...Victor ..." );
        System.out.println(  "\t"  + lista );

        //lista.set(1,"tita");  out of bound exception
        lista.set(0,"tita");        
        System.out.println( "\nreplace evelyn, set(0, tita) ..." );
        System.out.println( "\t" + lista );
        
        lista.remove("tita");
        System.out.println( "\nremove (tita) ..." );
        System.out.println( "\t" + lista ); 

        lista.remove("rosa");
        System.out.println( "\nremove (rosa) ..." );
        System.out.println( "\t" + lista );    

        lista.add("evelyn");
        System.out.println(  "\nadding eve..." );
        System.out.println(  "\t"  + lista );  

        lista.add(0, "evelyn");
        System.out.println(  "\nadding eve at 0..." );
        System.out.println(  "\t"  + lista ); 

        lista.add("evelyn");
        System.out.println(  "\nadding eve..." );
        System.out.println(  "\t"  + lista );     

        System.out.println(  "\nfirst index eve..." );
        System.out.println(  "\t"  + lista.firstIndex("evelyn") );

        System.out.println(  "\nlast index eve..." );
        System.out.println(  "\t"  + lista.lastIndex("evelyn") );   

        System.out.println(  "\nfirst index luisa..." );
        System.out.println(  "\t"  + lista.firstIndex("luisa") );

        System.out.println(  "\nlast index luisa..." );
        System.out.println(  "\t"  + lista.lastIndex("luisa") );

        System.out.println(  "\nfirst index luiso..." );
        System.out.println(  "\t"  + lista.firstIndex("luiso") );

        System.out.println(  "\nlast index luiso..." );
        System.out.println(  "\t"  + lista.lastIndex("luiso") );

        lista.removeAll("evelyn");
        System.out.println( "\nremoveAll evelyn ..." );
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