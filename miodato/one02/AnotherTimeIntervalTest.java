import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
import one01.TimeInterval;
import one02.AnotherTimeInterval;

class AnotherTimeIntervalTest{
    public static void main(String[] args){
        TimeInterval intervalo01 = new TimeInterval();
        AnotherTimeInterval intervalo02 = new AnotherTimeInterval();
        
        StdOut.println("Initial java.util.date based diff : " + intervalo01.getMilliSecondsDiference() + " milliseconds.");
        StdOut.println("Initial Duration, java.time.Duration based: " + intervalo02.getDuration());
         
        intervalo01.setTimeB();
        intervalo02.stop();
        StdOut.println("\nAfter 2 print instructions, java.util.date based diff: " + intervalo01.getMilliSecondsDiference() + " milliseconds.");
        StdOut.println("Duration after 2 print instructions, java.time.Duration based: " + intervalo02.getDuration());
        StdOut.println("");
        for(byte b = 0; b < 100; b++) { // using 128 or bigger, you get an overflow and an infinite loop 
                StdOut.print(b + " : ");
        }        
        StdOut.println("");
        
        
        intervalo01.setTimeB();
        intervalo02.stop();
        StdOut.println("After 105 print instructions, java.util.date based diff: " + intervalo01.getMilliSecondsDiference() + " milliseconds.");
        StdOut.println("Duration after 105 print instructions, java.time.Duration based: " + intervalo02.getDuration());
        
        StdOut.println("\nType a number :"); 
        StdIn.readInt();
        intervalo01.setTimeB();
        intervalo02.stop();
        StdOut.println("\nAfter input, java.util.date based diff: " + intervalo01); // uses toString()
        StdOut.println("Duration after input, java.time.Duration based: " + intervalo02);
        StdOut.printf("get nano: " + "%,d", intervalo02.getDuration().getNano());
        StdOut.println("");
    }
}
 
