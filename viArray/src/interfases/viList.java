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

    //public boolean remove(E elm);

    public int firstIndex(E elm);
}