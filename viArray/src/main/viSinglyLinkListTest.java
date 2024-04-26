package main;

import estructura_dato.viSinglyLinkList;
import interfases.viList;

public class viSinglyLinkListTest{
    public static void main(String[] args){
        viList <String> lista = new viSinglyLinkList<String> ();
        System.out.println( lista );
        lista.add("victor");
        System.out.println( lista );

        viList <Integer> listaInt = new viSinglyLinkList<Integer> ();
        System.out.println( listaInt );
        listaInt.add(1024);
        System.out.println( listaInt );


        //print with Iterator
    }

    public static void toUpper( viList<String> list){
        for(int n = 0; n < list.size(); n++){
            String firstLetterToUpper = String.valueOf( list.get(n).charAt(0) ).toUpperCase();
            String otherLetters = list.get(n).substring(1);
            //list.set( n,  firstLetterToUpper + otherLetters  ) ;
        }
    }
}