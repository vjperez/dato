package main;

import estructura_dato.viSinglyLinkList;
import interfases.viList;

public class viSinglyLinkListTest{
    public static void main(String[] args){
        System.out.println("lista : String");
        viList <String> lista = new viSinglyLinkList<String> ();
        System.out.println( lista );
        lista.add("victor");
        toUpper(lista);
        System.out.println( lista );
        lista.add("cheo");
        System.out.println( lista );
        lista.add("rosa");
        System.out.println( lista );        
        lista.remove("cheo");
        System.out.println( lista );
        lista.remove("Victor");
        System.out.println( lista );
        lista.remove("rosa");
        System.out.println(lista );        


        System.out.println("\nlistaInt : Integer");
        viList <Integer> listaInt = new viSinglyLinkList<Integer> ();
        System.out.println(listaInt );
        Integer n = 1024;  //if int is used, add(int) is implicitly casted to add(Integer), remove(int) produces outOfBoundException
        listaInt.add(n);
        System.out.println( listaInt );
        listaInt.remove(n);  //make sure class Integer is used as node element, remove(Integer element) , otherwise remove(index) is used
        System.out.println( listaInt );


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