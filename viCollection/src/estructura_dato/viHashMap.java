 package estructura_dato;

 import interfases.viMap;
 import interfases.viList;
 import estructura_dato.viArray;
 import estructura_dato.viDoubleLinkIterableList;

 import java.util.NoSuchElementException;
 
 public class viHashMap<K, V> implements viMap{
    private int size;
    private viList<viList<  Bucket<K, V>  >> buckets;
    //a small prime number, as lenght for underlying viArray
    private static final int InitialCapacity = 11;

    public viHashMap(int length){
        this.size = 0;
        this.buckets = new viArray<viList<  Bucket<K, V>  >>( length ); 
        for(int i = 0; i < length; i++){
            buckets.add ( new viDoubleLinkIterableList<  Bucket<K, V>  >() );
        }
    }
    //calls other constructor with default hashmap initial capacity for viArray 
    public viHashMap(){
        this( viHashMap.InitialCapacity );
    }
    //add a constructor that receives a viHashMap and returns a 'copy' of itself

    public int size(){ return this.size; }

    public boolean isEmpty(){ return this.size == 0; }



    private class Bucket<K, V>{
        private K key;
        private V value;

    }//Bucket class
 }//viHashMap class