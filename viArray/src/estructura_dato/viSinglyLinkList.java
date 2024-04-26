package estructura_dato;

import interfases.viList;
import java.util.NoSuchElementException;

public class viSinglyLinkList<E> implements viList<E>{
    private int size;
    private Nodo<E> head;

    public viSinglyLinkList(){
        this.size = 0;
        this.head = null;
    }

    //returns size of the list
    public int size(){
        return this.size;
    }
    

    private class Nodo<E>{
        private E elemento;
        private Nodo<E> next; 

        public Nodo(){
            this.elemento = null;
            this.next = null;
        }
    }

}//viSinglyLinkList