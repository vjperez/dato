package estructura_dato;

import interfases.viList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class viDoubleLinkIterableList<E> implements viList<E>, Iterable<E>{
    private int size;
    private Nodo<E> head;
    private Nodo<E> rabo;

    public viDoubleLinkIterableList(){
        this.size = 0;
        /* 
        if you do it this way, this.head.next is initialized to this.rabo while it is null
        ... this.head.getNext() is the node returned by this.getNode(0, elm) when you want to add
        on an empty list, it is supposed to be this.rabo to add before it, but instead
        it is null. So the instruction, Nodo<E> left  = toBeOnRight.getPrev(); on this.add(0, elm)
        ends up calling null.getPrev(), ... a run time exception
                this.head = new Nodo<E> (null, this.rabo, null);
                this.rabo = new Nodo<E> (this.head, null, null);
        */
        this.head = new Nodo<E> ( );  
        this.rabo = new Nodo<E> ( );   
        this.head.next = this.rabo;
        this.rabo.prev = this.head;
    }

    //returns size of the list
    public int size(){
        return this.size;
    }
    
    public boolean isEmpty(){ 
        return  this.size == 0  &&  this.head.next == this.rabo  &&  this.rabo.prev == this.head;
    }

    //Benefits from having this.rabo dummy node and prev references
    //Should be O(1) now
    public void add(E elm){
        this.add(this.size, elm);
    }

    public void add(int index, E elm){
        if(index < 0 || index > this.size) throw new IndexOutOfBoundsException();
    
        Nodo<E> toAdd = new Nodo<E> (elm);
    
        Nodo<E> toBeOnRight = this.getNode(index);
        Nodo<E> left  = toBeOnRight.getPrev();
        toAdd.setNext( toBeOnRight );
        toAdd.setPrev( left );
        left.setNext ( toAdd );
        toBeOnRight.setPrev( toAdd );
        
        this.size++;
    }    

    public boolean remove(int index){
        if(this.isEmpty())  throw new NoSuchElementException();
        if(index < 0 || index >= this.size) throw new IndexOutOfBoundsException();

        Nodo<E> toRemove = this.getNode(index);
        Nodo<E> previous = toRemove.getPrev();
        previous.setNext( toRemove.getNext() );
        toRemove.getNext().setPrev( previous );
        toRemove.clear();
        this.size--;
        return true;        
    }

    public boolean remove(E elm){
        if(this.isEmpty())  throw new NoSuchElementException();
        
        //head.getNext() references the node with 'index' 0
        //currentNodo and i advance at the same time
        Nodo<E> currentNodo = this.head.getNext();
        for(int i = 0;
            i < this.size;
            i++, currentNodo = currentNodo.getNext() )
        {
                if(elm.equals( currentNodo.getElemento() ))  return  remove(i);
        }

/*
        //start at rabo, moving to prev
        Nodo<E> currentNodo = this.rabo.getPrev();
        for(int i = -1 + this.size;
            i >= 0;
            i--, currentNodo = currentNodo.getPrev() )
        {
                if(elm.equals( currentNodo.getElemento() ))  return  remove(i);
        }
*/
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
        
        //head.getNext() references the node with 'index' 0
        //currentNodo and i advance at the same time        
        Nodo<E> currentNodo = this.head.getNext();
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
        
        //head.getNext() references the node with 'index' 0
        //currentNodo and i advance at the same time
        Nodo<E> currentNodo = this.head.getNext();
        for(int i = 0;
            i < this.size;
            i++, currentNodo = currentNodo.getNext() )
        {
                if(elm.equals( currentNodo.getElemento() ))  return i;
        }

        return -1;  
    }   

    //Benefits from having this.rabo dummy node and prev references
    public int lastIndex(E elm){
        if(this.isEmpty())  throw new NoSuchElementException();
        
        //rabo.getPrev() references the node with 'index' == -1 + this.size
        //currentNodo and i 'decrease' at the same time
        Nodo<E> currentNodo = this.rabo.getPrev();
        for(int i = -1 + this.size;
            i >= 0;
            i--, currentNodo = currentNodo.getPrev() )
        {
                if(elm.equals( currentNodo.getElemento() ))  return  i;
        }

        return -1; //here i must be -1 and currentNodo must be this.head
    }

    public boolean contains(E elm){
        if(this.isEmpty())  throw new NoSuchElementException();
        
        //head.getNext() references the node with 'index' 0
        //currentNodo and i advance at the same time
        Nodo<E> currentNodo = this.head.getNext();
        for(int i = 0;
            i < this.size;
            i++, currentNodo = currentNodo.getNext() )
        {
                if(elm.equals( currentNodo.getElemento() ))  return true;
        }
/*
        //start at rabo, moving to prev
        Nodo<E> currentNodo = this.rabo.getPrev();
        for(int i = -1 + this.size;
            i >= 0;
            i--, currentNodo = currentNodo.getPrev() )
        {
                if(elm.equals( currentNodo.getElemento() ))  return  true;
        }
*/
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
    //implemented using iterator
    public String toString(){
        String str = "[ ";

        Iterator iterador = this.iterator();
        while( iterador.hasNext() ){
            str += iterador.next() + " ";
            /*
            if ((n + 1) == this.size())           str += this.get(n)       ;
            else                                  str += this.get(n) + ", ";
            */
        }
        str += "]";
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

    //returns node at index, or
    //the dummy node at end (rabo), when index == this.size.
    //In either case,  this.add(index, elm), will add nodes, to the left
    //of the node returned by this.getNode(index)
    //In the worst case, moves on half the list
    //Benefits from having this.rabo dummy node and prev references
    public Nodo<E> getNode(int index){
        //when index == this.size, this implementation returns the dummy node
        //this.rabo, so do not throw exception when index == this.size
        if(index < 0 || index > this.size) throw new IndexOutOfBoundsException();
        
        if(index <= (this.size / 2)){//start from head, moving to next
            //head.getNext() references the node with 'index' 0 or 
            //this.rabo for getNode(0) on an empty list
            //currentNodo and i, advance at the same time
            Nodo<E> currentNodo = this.head.getNext();
            for(int i = 0;   
                i < index;   
                i++, currentNodo = currentNodo.getNext() )
            {}//for has empty body

            return currentNodo;
        }else{//start at rabo, moving to prev
            //this.rabo references the node with 'index' = this.size (a dummy node) 
            //currentNodo and i, 'decrease', 'go to prev', at the same time
            Nodo<E> currentNodo = this.rabo;
            for(int i = this.size;   
                i > index;   
                i--, currentNodo = currentNodo.getPrev() )
            {}//for has empty body

            return currentNodo;
        }
    }  

    private class Nodo<E>{
        private E elemento;
        private Nodo<E> next; 
        private Nodo<E> prev;

        public Nodo(){
            this(null, null, null);
        }
        public Nodo(E elm){
            this(null, null, elm);
        }
        public Nodo(Nodo<E> prev, Nodo<E> next, E elm){
            this.elemento = elm;
            this.prev = prev;
            this.next = next;
        }        


        public void clear(){ 
            this.elemento = null;
            this.prev = null;
            this.next = null;
        }
        public E getElemento(){
            return this.elemento;
        }         
        public Nodo<E> getNext(){
            return this.next;
        } 
        public Nodo<E> getPrev(){
            return this.prev;
        }  
        public void setNext(Nodo<E> next){
            this.next = next;
        } 
        public void setPrev(Nodo<E> prev){
            this.prev = prev;
        } 
        public void setElemento(E elm){
            this.elemento = elm;
        }                 
    }//Nodo




    public Iterator<E> iterator(){
        return new viIterator<E> ( this.head.getNext() );
    }

    private class viIterator<E> implements Iterator<E>{
        private Nodo<E> nodo;

        public viIterator(Nodo<E> nodo){
            this.nodo = nodo;
        }

        public boolean hasNext(){
            return this.nodo.getNext() != null   &&   this.nodo.getElemento() != null;
        }

        public E next(){
            E elm = this.nodo.getElemento();
            this.nodo = this.nodo.getNext();
            return elm;
        }

        public void remove(){
            if ( ! this.hasNext() ) throw new NoSuchElementException();

            Nodo<E> left  = this.nodo.getPrev();
            Nodo<E> right = this.nodo.getNext();
            left.setNext ( this.nodo.getNext() );
            right.setPrev( this.nodo.getPrev() );
            this.nodo.clear();
            this.nodo = right;
        }
    }//viIterator

}//viDoubleLinkIterableList