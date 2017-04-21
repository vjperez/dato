/**
 * Keeps a total and the amount of elements (N), to be used to calculate
 * an average. 
 */
public class Averager{
    private double total;
    private int n;
    private final String name;
    
    //Constructor
    Averager(String name){
        this.name = name;
    }
    
    //Change state (setter methods)
    public void addElement(double element){
        total += element;
        n++;
    }
    
    //Getter methods
    public String toString(){
        return "Average:" + name + ":" + average();
    }
    public double average(){
        if(n==0) return 0.0;
        return total / n;
    }
    public String getName(){
        return name;
    }
}
