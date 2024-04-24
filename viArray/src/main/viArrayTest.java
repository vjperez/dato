package main;

import estructura_dato.viArray;
import interfases.viList;

public class viArrayTest{
    public static void main(String[] args){
        viList <String> lista = new viArray <String>();
        lista.add("victor");
        lista.add("rosa");
        lista.add("viso");
        lista.add(2,"index 2");
        lista.add(0,"index 0");
        lista.remove(0);
        lista.remove(3);
        lista.add("victor");
        lista.add("tito");
        lista.add("victor");
        lista.removeAll_O_N("victor");
        lista.add(0,"viso");
        lista.add(1,"viso");
        lista.add("viso");
        lista.removeAll_O_N2("viso");

        //print with classic for
        for(int n = 0; n < lista.size(); n++){
            if ((n + 1) == lista.size()) System.out.print( lista.get(n) + "\n");
            else                         System.out.print( lista.get(n) + ", ");
        }

        viList <Integer> listaInt = new viArray <Integer>();
        listaInt.first();
        listaInt.add(1);
        listaInt.add(1,2);
        listaInt.add(0,3);
        //listaInt.set(3,12);     //exception
        //listaInt.set(-1,12);    //exception
        listaInt.add(3,4);
        listaInt.set(3,99);

        listaInt.clear();

        listaInt.first();

        //print with classic for
        for(int n = 0; n < listaInt.size(); n++){
            if ((n + 1) == listaInt.size()) System.out.print( listaInt.get(n) + "\n");
            else                            System.out.print( listaInt.get(n) + ", ");
        }

        //print with toString()

        //print with Iterator

        //are there online unit tests for these ?
    }
}