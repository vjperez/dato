package main;

import estructura_dato.viArray;
import interfases.viList;

public class viArrayTest{
    public static void main(String[] args){
        viList <String> lista = new viArray <String>(1);
        lista.add("victor");  
        System.out.println( lista );
        lista.add("rosa");
        System.out.println( lista );
        lista.add("viso");
        System.out.println( lista );
        lista.add(2,"index 2");
        System.out.println( lista );
        lista.add(0,"index 0");
        System.out.println( lista );
        lista.remove(0);
        System.out.println( lista );
        lista.remove(3);
        System.out.println( lista );
        lista.add("victor");
        System.out.println( lista );
        lista.add("tito");
        System.out.println( lista );
        lista.add("victor");
        System.out.println( lista );
        lista.removeAll_O_N("victor");
        System.out.println( lista );
        lista.add(0,"viso");
        System.out.println( lista );
        lista.add(1,"viso");
        System.out.println( lista );
        lista.add("viso");
        System.out.println( lista );
        lista.removeAll_O_N2("viso");
        System.out.println( lista );

        //print with classic for
        /*
        for(int n = 0; n < lista.size(); n++){
            if ((n + 1) == lista.size()) System.out.print( lista.get(n) + "\n");
            else                         System.out.print( lista.get(n) + ", ");
        }
        */

        viList <Integer> listaInt = new viArray <Integer>();
        listaInt.add(1);
        System.out.println( listaInt );
        listaInt.add(1,2);
        System.out.println( listaInt );
        listaInt.add(0,3);
        System.out.println( listaInt );
        //listaInt.set(3,12);     //exception
        //listaInt.set(-1,12);    //exception
        listaInt.add(3,4);
        System.out.println( listaInt );
        listaInt.set(3,99);
        System.out.println( listaInt );

        listaInt.clear();
        System.out.println( listaInt );
    
        //System.out.println( "first: " + listaInt.first() );  //exception


        //print with classic for
        /*
        for(int n = 0; n < listaInt.size(); n++){
            if ((n + 1) == listaInt.size()) System.out.print( listaInt.get(n) + "\n");
            else                            System.out.print( listaInt.get(n) + ", ");
        }
        */

        

        //print with Iterator
        //are there online unit tests for these ?
    }
}