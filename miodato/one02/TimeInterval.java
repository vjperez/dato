package one02;

import java.time.Instant;
import java.time.Duration;

/**
 * Measuring a time interval using time duration and time instant
 */
public class TimeInterval{  
    private Instant start;
    private Instant stop;    
    
    public TimeInterval(){
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
    
    //public String toString(){
    //    return getDuration.toHours() + " hrs:   " + getDuration.toMinutes() + " min:   " + seconds + " sec:   " + millis + " millisec"; 
    //}
}


