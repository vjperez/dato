package interfases;

public interface viList<E>{

    //returns size of the list
    public int size();

    public boolean isEmpty();

    public void add(E elm);

    public void add(int index, E elm);

    public E get(int index);

    public void set(int index, E elm);

    public boolean remove(int index);

    public int firstIndex(E elm);

    public int lastIndex(E elm);

    public boolean remove(E elm);

    public boolean contains(E elm);

    //big oh (n^2)
    public int    removeAll_O_N2(E elm); 

    //big oh (n)
    public int    removeAll_O_N(E elm);

    public void clear();

    public E first();

    public E last();
}