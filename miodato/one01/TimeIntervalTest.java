import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import one01.TimeInterval;


class TimeIntervalTest{
    public static void main(String[] args){
        TimeInterval intervalo = new TimeInterval();
        StdOut.println("Initial java.util.date based diff : " + intervalo.getMilliSecondsDiference() + " milliseconds.");
        StdOut.println("Initial Duration, java.time.Duration based: " + intervalo.getDuration());
        
        intervalo.setTimeB();
        StdOut.println("\nAfter 2 print instructions, java.util.date based diff: " + intervalo.getMilliSecondsDiference() + " milliseconds.");
        StdOut.println("Duration after 2 print instructions, java.time.Duration based: " + intervalo.getDuration() );
        StdOut.println("");
        for(byte b = 0; b < 100; b++) { // using 128 or bigger, you get an overflow and infinite loop 
                StdOut.print(b + " : ");
        }        
        StdOut.println("");
        
        
        intervalo.setTimeB();
        StdOut.println("After 105 print instructions, java.util.date based diff: " + intervalo.getMilliSecondsDiference() + " milliseconds.");
        StdOut.println("Duration after 105 print instructions, java.time.Duration based: " + intervalo.getDuration());
        
        StdOut.println("\nType a number :"); 
        StdIn.readInt();
        intervalo.setTimeB();
        StdOut.println("\nAfter input, java.util.date based diff: " + intervalo); // uses toString()
        StdOut.println("Duration after input, java.time.Duration based: " + intervalo.getDuration());
    }
}
