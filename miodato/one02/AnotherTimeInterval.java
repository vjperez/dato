package one02;

import java.time.Instant;
import java.time.Duration;

/**
 * Measuring a time interval using time duration and time instant
 */
public class AnotherTimeInterval{  
    private Instant start;
    private Instant stop;    
    
    public AnotherTimeInterval(){
        start = stop = Instant.now();
    }

    public void start(){
        start = Instant.now();
    }
    
    public void stop(){
        stop = Instant.now();
    }
    
    public Duration getDuration(){
		return Duration.between(start, stop);
	}
   
    public String toString(){
		long secondsValue = getDuration().getSeconds();
		int nanoValue = getDuration().getNano();
		long hrs = secondsValue / 3600;
		secondsValue = secondsValue % 3600;
		long mins = secondsValue / 60;
		secondsValue = secondsValue % 60;
		int millis = nanoValue / 1000000;
		nanoValue = nanoValue % 1000000;
		int micros = nanoValue / 1000;
		nanoValue = nanoValue % 1000;
        return hrs + " hrs:   " + mins + " min:   " + secondsValue + " sec:   " + millis + " millisec:   "  + micros + " micros:   " + nanoValue + " nanos"; 
    }
}


