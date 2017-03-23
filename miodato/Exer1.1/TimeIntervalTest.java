import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;


class TimeIntervalTest{
    public static void main(String[] args){
        TimeInterval intervalo = new TimeInterval();
        StdOut.println("Initial diff : " + intervalo.getMilliSecondsDiference() + " milliseconds.");
        
        
        intervalo.setTimeB();
        StdOut.println("After 1 print instruction: " + intervalo.getMilliSecondsDiference() + " milliseconds.");
        for(byte b = 0; b < 100; b++) { // using 128 or bigger, you get an overflow and infinite loop 
                StdOut.print(b + " : ");
        }        
        StdOut.println("");
        
        
        intervalo.setTimeB();
        StdOut.println("After 102 print instructions: " + intervalo.getMilliSecondsDiference() + " milliseconds.\nType a number : ");
        
        
        StdIn.readInt();
        intervalo.setTimeB();
        StdOut.println("After input: " + intervalo.getMilliSecondsDiference() + " milliseconds.");
    }
}
