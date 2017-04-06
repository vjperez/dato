import edu.princeton.cs.algs4.StdOut;

class DiezYOcho{
    
    public static int producto(int x, int y){
        if(y == 0) return 0;
        if(y % 2 == 0) return producto(x+x, y/2); // si "y" es par
        return x + producto(x+x, y/2);            // si "y" es impar
    }
    
    
    public static long power(int x, int y){
        if(y==0) return 1;
        if(y % 2 == 0) return power(x*x, y/2);
        return x * power(x*x, y/2);
    }
    
    
    public static void main(String[] args){
        StdOut.println("4 X 10 = " + producto(4,10));
        StdOut.println("12 X 100 = " + producto(12,100));
        StdOut.println("34 X 7 = " + producto(34,7));
        
        StdOut.println("2 ^ 10 = " + power(2,10));
        StdOut.println("3 ^ 4 = " + power(3,4));
        StdOut.println("5 ^ 4 = " + power(5,4));
    }
}
