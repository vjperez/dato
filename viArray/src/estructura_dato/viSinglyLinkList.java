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
    
    public boolean isEmpty(){ return  this.size == 0  &&  this.head == null; }

    public void add(E elm){
        this.add(this.size, elm);
    }

    public void add(int index, E elm){
        if(index < 0 || index > this.size) throw new IndexOutOfBoundsException();
        Nodo<E> toAdd = new Nodo<E> (elm);
        if(index == 0){
            toAdd.setNext( this.head );
            this.head = toAdd;
            this.size++;
        }else{
            Nodo<E> previous = this.getNode(-1 + index);
            toAdd.setNext( previous.getNext() );
            previous.setNext( toAdd );
            this.size++;
        }
    }    

    //toString() from Object class 
    public String toString(){
        String str = "[ ";
        for(int n = 0; n < this.size(); n++){
            if ((n + 1) == this.size())           str += this.get(n)       ;
            else                                  str += this.get(n) + ", ";
        }
        str += " ]";
        return str;
    }

    public void set(int index, E elm){
        if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
        this.getNode(index).setElemento(elm);
    }

    public E get(int index){
        if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
        return this.getNode(index).getElemento();
    }

    public Nodo<E> getNode(int index){
        if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
        Nodo<E> currentNodo = this.head;
        for(int n = 0; n < index; n++){
            currentNodo = currentNodo.getNext();
        }
        return currentNodo;
    }  

    private class Nodo<E>{
        private E elemento;
        private Nodo<E> next; 

        public Nodo(){
            this(null, null);
        }
        public Nodo(E elm){
            this(null, elm);
        }
        public Nodo(Nodo<E> next, E elm){
            this.elemento = elm;
            this.next = next;
        }        


        public void clear(){ 
            this.elemento = null;
            this.next = null;
        }
        public Nodo<E> getNext(){
            return this.next;
        } 
        public E getElemento(){
            return this.elemento;
        }  
        public void setNext(Nodo<E> next){
            this.next = next;
        } 
        public void setElemento(E elm){
            this.elemento = elm;
        }                 
    }//Nodo

}//viSinglyLinkList