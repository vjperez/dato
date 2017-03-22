import edu.princeton.cs.algs4.StdOut;

class DiezYSeis{
    
    
    public static String f(int x){
        if(x <= 0) return "";
        else return f(x-3) + x + f(x-2) + x;
    }
    
    
    public static void main(String[] args){
        StdOut.println( f(6) );
    }
}
