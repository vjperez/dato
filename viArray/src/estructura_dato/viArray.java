package estructura_dato;

import interfases.viList;

//casting an object[] to E[] throws a warning for an unchecked operation
//this supresses the warning
@SuppressWarnings("unchecked")
public class viArray<E> implements viList<E>{
    private int nextIndex;
    private E[] elementos;

    public viArray(int length){
        this.nextIndex = 0;
        this.elementos = ( E[] ) new Object[ length ];
    }
    //calls other constructor with default array length of 8
    public viArray(){
        this(8);
    }


    //returns size of the list
    public int size(){
        return this.nextIndex;
    }

    public boolean isEmpty(){
        return this.nextIndex == 0;
    }

    //not on interface, full and resize only needed when List implemented on array
    public boolean isFull(){
        return this.nextIndex == this.elementos.length;
    }

    public void add(E elm){
        this.add(this.nextIndex, elm);
    }

    public void add(int index, E elm){
        if (index < 0  ||  index > nextIndex) throw new IndexOutOfBoundsException();
        if(this.isFull()) this.enlargeArray();
        for(int i = nextIndex; i > index; i--){
            this.elementos[i] = this.elementos[i - 1];
        }
        this.elementos[index] = elm;  
        this.nextIndex++;
    }

    //not on interface, resize only needed when List implemented on array 
    private void enlargeArray(){
        E[] largerArray = ( E[] ) new Object[ 2 * this.elementos.length ];
        for(int i = 0; i < this.elementos.length; i++){
            largerArray[i] = this.elementos[i];
            this.elementos[i] = null;  //helping with garbage collection
            i++;
        }
        this.elementos = largerArray;
    }

    public E get(int index){
        if (index < 0  ||  index >= nextIndex) throw new IndexOutOfBoundsException();
        return this.elementos[index]; 
    }

    //could be implemented to return the replaced element
    public void set(int index, E elm){
        if (index < 0  ||  index >= nextIndex) throw new IndexOutOfBoundsException();
        this.elementos[index] = elm;
    }

    public boolean remove(int index){
        if (index < 0  ||  index >= nextIndex) throw new IndexOutOfBoundsException();
        for(int i = index; i + 1 < this.size(); i++){
            this.elementos[i] = this.elementos[i + 1];
        }
        this.elementos[-1 + this.size()] = null;   //helping with garbage collection
        this.nextIndex--;                
        return true;
    }

    public int firstIndex(E elm){
        int index = -1;
        for(int i = 0; i < this.size(); i++){
            this.elementos[i] = this.elementos[i + 1];
        }
        return index;
    }
 
    //toString() : implemention from Object class
    //public String 
}//viArray