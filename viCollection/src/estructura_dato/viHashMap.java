 package estructura_dato;

 import interfases.hashKey;
 import interfases.viMap;
 
 import estructura_dato.viArray;
 import estructura_dato.viDoubleLinkIterableList;
 
 public class viHashMap<K, V> implements viMap<K, V>{
    private int size;
    private viArray< viDoubleLinkIterableList< Bucket<K, V> >> buckets;

    private hashKey<K> hkObj;
    


    //a small prime number, as lenght for underlying viArray
    //private static final int InitialCapacity = 11;
    //calls other constructor with default hashmap initial capacity for viArray 
    /*
    public viHashMap( hashKey<K> hkObj ){
        this( viHashMap.InitialCapacity, hkObj );
    }
    */

    public viHashMap(int length, hashKey<K> hkObj){
        this.size = 0;
        this.buckets = new viArray< viDoubleLinkIterableList< Bucket<K, V> >> ( length ); 
        for(int i = 0; i < length; i++){
            buckets.add ( new viDoubleLinkIterableList< Bucket<K, V> >() );
        }
        this.hkObj = hkObj;
    }

    //add a constructor that receives a viHashMap and returns a 'copy' of itself



    public int size(){ return this.size; }

    public boolean isEmpty(){ return this.size == 0; }

    public V get(K key){
        int index = hkObj.hashTheKey( key );
        viDoubleLinkIterableList< Bucket<K, V> > bucketList = this.buckets.get( index );

        for(int i = 0; i < bucketList.size(); i++){
            Bucket<K, V> bucket = bucketList.get(i);
            if( bucket.getKey() == key ) { 
                return bucket.getVal();
            }
        }
        return null;  // key not found
    }

    public V put(K key, V value){
        if ( key == null  ||  value == null ) throw new IllegalArgumentException();
        
        int index = hkObj.hashTheKey( key );
        viDoubleLinkIterableList< Bucket<K, V> > bucketList = this.buckets.get( index );
        Bucket<K, V> bucketToPut = new Bucket<K, V> (key, value);

        int i = 0;
        while( i < bucketList.size() ){
            Bucket<K, V> bucket = bucketList.get(i);
            if( bucket.getKey() == key ) {
                V removedValue = bucket.getVal();
                bucket.clear();//helping with garbage collection.
                bucketList.remove(i);
                bucketList.add(0, bucketToPut);
                //this.size stays equals, this is really, replace(key, value) . What if value is also the same?
                return removedValue;
            }
            i++; 
        }  

        //instead of replace(key, value), this is putting pair when key is absent 
        bucketList.add(0, bucketToPut);
        this.size++;
        return null;
    }

    public V remove(K key){
        int index = hkObj.hashTheKey( key );
        viDoubleLinkIterableList< Bucket<K, V> > bucketList = this.buckets.get( index );
        
        int i = 0;
        while( i < bucketList.size() ){
            Bucket<K, V> bucket = bucketList.get(i);
            if( bucket.getKey() == key ){
                V removedValue = bucket.getVal();
                bucket.clear();//helping with garbage collection.
                bucketList.remove(i);
                this.size--;
                return removedValue;
            }
            i++;
        }  
        //nothing removed, nothing happened, wasted time just looping
        return null;
    }

    public void clear(){
        for(int out = 0; out < this.buckets.size(); out++){
            viDoubleLinkIterableList< Bucket<K, V> > bucketList = this.buckets.get( out );
            for(int in = 0; in < bucketList.size(); in++){
                Bucket<K, V> bucket = bucketList.get( in );
                bucket.clear(); //helping with garbage collection
            }
            bucketList.clear(); // clear the duoble link lists, using iterator this could probably be done inside previous loop
        }
        this.buckets.clear(); // clear the dynamic viArray
    }

    public boolean contains(K key){
        return  this.get(key)  !=  null;
    }

    public String toString(){
        String str = "";
        for(int out = 0; out < this.buckets.size(); out++){
            viDoubleLinkIterableList< Bucket<K, V> > bucketList = this.buckets.get( out );
            str += '\t' + bucketList.toString() +  '\n';
        }
        return str;
    }


    private class Bucket<K, V>{
        private K key;
        private V value;

        public Bucket(K key, V value){
            this.key = key;
            this.value = value;
        }

        public void clear(){
            this.key = null;
            this.value = null;            
        }
        public K getKey()  { return this.key; }
        public V getVal(  ){ return this.value; }
        public String toString() {  return this.key + ":" + this.value;  }
    }//Bucket class

 }//viHashMap class