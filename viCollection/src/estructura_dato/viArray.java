package estructura_dato;

import interfases.viList;
import java.util.NoSuchElementException;

//casting an object[] to E[] throws a warning for an unchecked operation
//this supresses the warning
@SuppressWarnings("unchecked")
public class viArray<E> implements viList<E>{
    private int nextIndex;
    private E[] elementos;
    private static final int ArrayInitialCapacity = 3;

    public viArray(int length){
        this.nextIndex = 0;
        this.elementos = ( E[] ) new Object[ length ];
    }
    //calls other constructor with default array initial capacity 
    public viArray(){
        this( viArray.ArrayInitialCapacity );
    }


    //returns size of the list
    public int size(){
        return this.nextIndex;
    }

    public boolean isEmpty(){
        return this.nextIndex == 0;
    }

    //not on interface, isFull() and enlargeArray() only needed when List implemented on array
    public boolean isFull(){
        return this.nextIndex == this.elementos.length;
    }

    public void add(E elm){
        this.add(this.nextIndex, elm);
    }

    public void add(int index, E elm){
        if (index < 0  ||  index > this.nextIndex) throw new IndexOutOfBoundsException();
        if(this.isFull()) this.enlargeArray();
        for(int i = this.nextIndex; i > index; i--){
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
        }
        this.elementos = largerArray;
    }

    public E get(int index){
        if (index < 0  ||  index >= this.nextIndex) throw new IndexOutOfBoundsException();
        return this.elementos[index]; 
    }

    //could be implemented to return the replaced element
    public void set(int index, E elm){
        if (index < 0  ||  index >= this.nextIndex) throw new IndexOutOfBoundsException();
        this.elementos[index] = elm;
    }
    
    //removing at index( -1 + this.size() ) is o(1), there is shifting for other indexes
    public boolean remove(int index){
        if (index < 0  ||  index >= this.nextIndex) throw new IndexOutOfBoundsException();
        for(int i = index; i + 1 < this.size(); i++){
            this.elementos[i] = this.elementos[i + 1];
        }
        this.elementos[-1 + this.size()] = null;   //helping with garbage collection.  Used on this.clear()
        this.nextIndex--;                
        return true;
    }

    public int firstIndex(E elm){
        int index = -1;
        for(int i = 0; i < this.size(); i++){
            if( elm.equals( this.elementos[i] ))  return i;
        }
        return index;
    }

    public int lastIndex(E elm){
        int index = -1;
        for(int i = -1 + this.size(); i >= 0; i--){
            if( elm.equals( this.elementos[i] ))  return i;
        }
        return index;
    }  

    public boolean remove(E elm){
        int at =  this.firstIndex(elm);
        if(at >= 0) return this.remove( at );
        else return false;
    }  

    public boolean contains(E elm){
        int at =  this.firstIndex(elm);
        if(at >= 0) return true;
        else return false;        
    }

    //big oh n^2
    private int removeAll_O_N2(E elm){
        int removed = 0;

        //remove(elm) uses firstIndex(elm) together with remove(index)
        //firstIndex(elm) will start from index 0 on every while iteration, 
            //which is unnecessary since elm is known not to be there
        //remove(index) will shift left all elements, from index to "index less than size()""
            //which is inefficient since elm could be there again, 
            //and following iterations will end up shifting left the same values, 
            //multiple times but only 1 position to the left
        while( this.remove(elm) ) removed++;

        return removed;
    }

    //big oh n
    private int removeAll_O_N(E elm){
        int shiftAmount = 0;

        int firstIndex = -1;
        for(int i = 0; i < this.size(); i++){
            if( elm.equals( this.elementos[i] )){
                firstIndex = i;
                shiftAmount++;
                break;
            }
        }
        //no first index found, nothing removed, no shifting, return zero
        if(firstIndex == -1) return shiftAmount;

        //inside while, either shiftAmount is increased, which removes copy of found elm
        //or a shift left is done
        //increasing shiftAmount makes it possible to shift elements, one 1 time by multiple positions,
        //instead of multiple times by 1 position
        while(firstIndex + shiftAmount < this.size()){
            if( elm.equals( this.elementos[ firstIndex + shiftAmount] )){
                shiftAmount++;
            }else{
                this.elementos[firstIndex] = this.elementos[ firstIndex + shiftAmount ];
                firstIndex++;
            }
        }
        //inside the for, the last "shiftAmount" positions are set to null
        for(int i = -shiftAmount + this.size(); i < this.size(); i++){
            this.elementos[i] = null;   //helping with garbage collection
        }
        //nextIndex is decremented
        this.nextIndex -= shiftAmount;
        return shiftAmount;
    }

    public int removeAll(E elm){
        return removeAll_O_N(elm);
    }

    public void clear(){
        /*
        for(int i = 0; i < this.size(); i++){
           this.elementos[i] = null; 
        }
        this.nextIndex = 0;
        */

       //use remove(index) to clear list, sending always last valid index as parameter
       //removing at index( -1 + this.size() ) is o(1), there is shifting for other indexes
       //remove(index) will set values to null and adjust this.nextIndex
       //Also if a reduceArray() function is implemented, there is no need to call it here
       //It may only be called on remove(index) and removeAll_O_N(E elm).  
       //Not on removeAll_O_N2(E elm),  which ends up calling remove(index) 
        for(int i = -1 + this.size(); i >= 0; i--){
           this.remove(i);
        }       
    }

    public E first(){ 
        if( this.isEmpty() ) throw new NoSuchElementException();
        return this.elementos[0]; 
        
    }

    public E last(){ 
        if( this.isEmpty() ) throw new NoSuchElementException();
        return this.elementos[-1 + this.nextIndex]; 
    }
 
    //toString() from Object class 
    public String toString(){
        String str = "Capacity:" + this.elementos.length + " :: [ ";
        for(int n = 0; n < this.size(); n++){
            if ((n + 1) == this.size())           str += this.get(n)       ;
            else                                  str += this.get(n) + ", ";
        }
        str += " ]";
        
        //remove indexOutBoundsException on get(index), and uncomment following code 
        //if you want to print null values on rest of array
        /*
        str += "\t\tNulls:: [ ";
        for(int n = this.size(); n < this.elementos.length; n++){
            if ((n + 1) == this.elementos.length) str += this.get(n)       ;
            else                                  str += this.get(n) + ", ";
        }
        str += " ]";
        */
        
        return str;
    }
    
}//viArray