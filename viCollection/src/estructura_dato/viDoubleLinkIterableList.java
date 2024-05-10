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
        this.head.next = this.rabo;//this.head.prev and this.head.elemento remains null
        this.rabo.prev = this.head;//this.rabo.next and this.rabo.elemento remains null
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
        toRemove.clear();//helping with garbage collection.
        this.size--;
        return true;        
    }

    public boolean remove(E elm){
        if(this.isEmpty())  throw new NoSuchElementException();
               
        for(viIterator<E> iter = this.iterator(); iter.hasNext(); ){
            //iterator not needed after removing, so dont used iter.getNode()
            //and iter.setNode() to save a reference.  See removeAll(elm) 
            if(elm.equals( iter.next() )){
                iter.remove();
                this.size--;
                return  true;
            }
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
        for(viIterator<E> iter = this.iterator(); iter.hasNext(); ){
            //saving a reference to come back after removing, needed because
            //iterator is still needed after removing
            Nodo<E> savedCurrent = iter.getNode();
            if(elm.equals( iter.next() )){
                
                iter.remove();
                iter.setNode( savedCurrent ); // after removing, back to where you came from
                this.size--;

                foundCount++;
            }
        }
        return foundCount;        
    }

    public int firstIndex(E elm){
        if(this.isEmpty())  throw new NoSuchElementException();
        
        //head.getNext() references the node with 'index' 0
        viIterator<E> iter = this.iterator();
        iter.next();
        for(int i = 0;
            i < this.size;
            i++, iter.next() )
        {
                if(elm.equals( iter.getNode().getElemento() ))  return i;
        }

        return -1;  
    }   

    //Benefits from having this.rabo dummy node and prev references
    public int lastIndex(E elm){
        if(this.isEmpty())  throw new NoSuchElementException();
        
        //rabo.getPrev() references the node with 'index' == -1 + this.size
        viIterator<E> iter = this.iteratorRabo();
        iter.prev();
        for(int i = -1 + this.size;
            i >= 0;
            i--, iter.prev() )
        {
                if(elm.equals( iter.getNode().getElemento() ))  return  i;
        }

        return -1; //here i must be -1 and currentNodo must be this.head
    }

    public boolean contains(E elm){
        if(this.isEmpty())  throw new NoSuchElementException();
        return  this.lastIndex(elm)  >  -1; 
    }

    //remove(index) will use getNode(index) to get node to remove
    //getNode(index) at worst case, will move over half the list, from the start or end depending on index
    //Both getNode(0) and getNode( -1 + this.size ), will get node on O(1)
    //getNode(0) do not enter for loop, getNode( -1 + this.size ) will enter for loop for only 1 iteration
    //so we clear from index  0
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
        String str = "doublelinklist using iterator: [ ";

        viIterator<E> iter = this.iterator();
        while( iter.hasNext() ){
            str += iter.next() + " ";
            /*
            //get(n) will use getNode() and move over list for every n value - O(n2)
            str += this.get(n) + ", ";
            */
        }
        str += "]";
        
        /*
        str += " - using enhanced for loop [ ";
        for(E elm: this){
            str += elm + " ";
        }
        str += "]";
        */
        
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
        
        if(index < (this.size / 2)){
            //start from head, moving to next
            viIterator<E> iter = this.iterator();
            iter.next();
            for(int i = 0;   
                i < index;   
                i++,  iter.next() )
            {}//for has empty body

            return  iter.getNode();
        }else{//start at rabo, moving to prev
            //this.rabo references the node with 'index' = this.size (a dummy node) 
            //including, getNode(0) on an empty list
            viIterator<E> iter = this.iteratorRabo();
            //iter.prev();

            //if only nodes with data were needed, this previous instruction, iter.prev(),
            //would be needed, together with i, starting at -1 + this.size
            //But i want to start at dummy node, this.rabo, where i = this.size
            //This is the node that must be returned when index = this.size
            for(int i = this.size;   
                i > index;   
                i--,  iter.prev() )
            {}//for has empty body

            return  iter.getNode();
        }
    }  

    private class Nodo<E>{ 
        private Nodo<E> prev;
        private Nodo<E> next;
        private E elemento;

        public Nodo(){
            this(null, null, null);
        }
        public Nodo(E elm){
            this(null, null, elm);
        }
        public Nodo(Nodo<E> prev, Nodo<E> next, E elm){
            this.prev = prev;
            this.next = next;
            this.elemento = elm;
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



    //iterator that starts at head, and must begin moving right 
    //using hasNext() and next()
    public viIterator<E> iterator(){
        return new viIterator<E> ( this.head, this.rabo, this.head );
    }
    //iterator that starts at rabo, and must begin moving left 
    //using hasPrev() and prev()
    public viIterator<E> iteratorRabo(){
        return new viIterator<E> ( this.head, this.rabo, this.rabo );
    }

    private class viIterator<E> implements Iterator<E>{
        private Nodo<E> targetNodo;
        private Nodo<E> iterHead;
        private Nodo<E> iterRabo;

        public viIterator(Nodo<E> iterHead, Nodo<E> iterRabo, Nodo<E> targetNodo){
            this.iterHead = iterHead;
            this.iterRabo = iterRabo;
            this.targetNodo = targetNodo; 
        }

        public boolean hasNext(){
            return this.targetNodo.getNext()  !=  this.iterRabo;
        }

        public E next(){
            if ( this.targetNodo == this.iterRabo ) throw new NoSuchElementException();
            this.targetNodo = this.targetNodo.getNext();
            return this.targetNodo.getElemento();
        }

        public boolean hasPrev(){
            return  this.targetNodo.getPrev()  !=  this.iterHead;
        }

        public E prev(){
            if ( this.targetNodo == this.iterHead ) throw new NoSuchElementException();
            this.targetNodo = this.targetNodo.getPrev();
            return this.targetNodo.getElemento();            
        }

        public void remove(){
            if ( this.targetNodo == this.iterHead  ||  this.targetNodo == this.iterRabo ) throw new NoSuchElementException();

            Nodo<E> left  = this.targetNodo.getPrev();
            Nodo<E> right = this.targetNodo.getNext();
            Nodo<E> saved = this.targetNodo;
            left.setNext ( this.targetNodo.getNext() );  //could also use right as parameter to setNext() 
            right.setPrev( this.targetNodo.getPrev() );  //could also use left as parameter to setPrev()
            this.targetNodo.clear(); //helping with garbage collection.
            //at this moment targetNodo is null, the caller must have saved a reference to reset it 
        }

        public Nodo<E> getNode(){
            return  this.targetNodo;
        }

        public void setNode( Nodo<E> targetNodo ){
            this.targetNodo = targetNodo;
        }
    }//viIterator

}//viDoubleLinkIterableList