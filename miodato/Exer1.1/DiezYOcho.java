import edu.princeton.cs.algs4.StdOut;

class DiezYOcho{
    
    
    public static int producto(int x, int y){
        if(y == 0) return 0;
        if(y % 2 == 0) return producto(x+x, y/2); // si "y" es par
        return x + producto(x+x, y/2);            // si "y" es impar
    }
    
    
    public static void main(String[] args){
        StdOut.println("4 X 10 = " + producto(4,10));
        StdOut.println("12 X 100 = " + producto(12,100));
        StdOut.println("34 X 7 = " + producto(34,7));
    }
}
