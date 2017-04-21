/**
 * Simply to count things, count can be increased, decreased or reseted. 
 */
public class Counter{
    private final String name;
    private int count;
    
    //Constructor
    Counter(String name){
        this.name = name;
    }
    
    //Change state (setter methods)
    public void increase(){
        count++;
    }
    public void increase(int x){
        count += x;
    }    

    public void decrease(){
        count--;
    }
    public void decrease(int x){
        count -= x;
    }
    public void reset(){
        count = 0;
    }

    //Getter methods
    public String toString(){
        return "Counter:" + name + ":" + count;
    }
    public int getCount(){
        return count;
    }
    public String getName(){
        return name;
    }
}
