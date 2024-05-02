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
        }else{
            Nodo<E> previous = this.getNode(-1 + index);
            toAdd.setNext( previous.getNext() );
            previous.setNext( toAdd );
        }
        this.size++;
    }    

    public boolean remove(int index){
        if(this.isEmpty())  throw new NoSuchElementException();
        if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();
        Nodo<E> toRemove = this.getNode(index);
        if(index == 0){
            this.head = toRemove.getNext();            
        }else{
            Nodo<E> previous = this.getNode( -1 + index );
            previous.setNext( toRemove.getNext() );
        }
        toRemove.clear();
        this.size--;
        return true;        
    }

    public boolean remove(E elm){
        if(this.isEmpty())  throw new NoSuchElementException();
        
        //head references the node with 'index' 0
        //currentNodo and i advance at the same time
        Nodo<E> currentNodo = this.head;
        for(int i = 0;
            i < this.size;
            i++, currentNodo = currentNodo.getNext() )
        {
                if(elm.equals( currentNodo.getElemento() ))  return  remove(i);
        }

        return false; 
    }

    public int removeAll(E elm){
        if(this.isEmpty())  throw new NoSuchElementException();
        
        int foundCount = 0;
        Nodo<E> nextNodo;

        //'i' is based on original list without removing anything
        //after removing, 'this.size' changes, to account for that, 
            //'foundCount' is added on 'for' condition
        //the index of element to be removed, is also based on original list, so ...
            //'foundCount' is substracted when removing
        
        //head references the node with 'index' 0
        //currentNodo and i advance at the same time        
        Nodo<E> currentNodo = this.head;
        for(int i = 0;
            i < this.size + foundCount;
            i++, currentNodo = nextNodo
           )
        {
                nextNodo = currentNodo.getNext();
                if(elm.equals( currentNodo.getElemento() )){
                    this.remove(-foundCount + i);
                    foundCount++;
                }
        }
        return foundCount;        
    }

    public int firstIndex(E elm){
        if(this.isEmpty())  throw new NoSuchElementException();
        
        //head references the node with 'index' 0
        //currentNodo and i advance at the same time
        Nodo<E> currentNodo = this.head;
        for(int i = 0;
            i < this.size;
            i++, currentNodo = currentNodo.getNext() )
        {
                if(elm.equals( currentNodo.getElemento() ))  return i;
        }

        return -1;  
    }   

    public int lastIndex(E elm){
        if(this.isEmpty())  throw new NoSuchElementException();
        int indexOfElm = -1;
        //head references the node with 'index' 0
        //currentNodo and i advance at the same time
        Nodo<E> currentNodo = this.head;
        for(int i = 0;
            i < this.size;
            i++, currentNodo = currentNodo.getNext() )
        {
                if(elm.equals( currentNodo.getElemento() ))  indexOfElm = i;
        }

        return indexOfElm;
    }

    public boolean contains(E elm){
        if(this.isEmpty())  throw new NoSuchElementException();
        
        //head references the node with 'index' 0
        //currentNodo and i advance at the same time
        Nodo<E> currentNodo = this.head;
        for(int i = 0;
            i < this.size;
            i++, currentNodo = currentNodo.getNext() )
        {
                if(elm.equals( currentNodo.getElemento() ))  return true;
        }

        return false; 
    }

    public void clear(){
        int firstIndex = 0;
        while( ! this.isEmpty()){
            this.remove(firstIndex);
            //this.remove( this.getNode(firstIndex).getElemento() ) ;
        }
    }

    public E first(){
        if(this.isEmpty())  throw new NoSuchElementException();
        
        return this.getNode(0).getElemento();
    }

    public E last(){
        if(this.isEmpty())  throw new NoSuchElementException();
        
        return this.getNode(-1 + this.size).getElemento();
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
    
        //head references the node with 'index' 0
        //currentNodo and i, advance at the same time
        Nodo<E> currentNodo = this.head;
        for(int i = 0;   
            i < index;   
            i++, currentNodo = currentNodo.getNext() )
        {}//for has empty body
            
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