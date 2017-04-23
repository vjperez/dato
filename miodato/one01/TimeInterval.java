package one01;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;

public class TimeInterval{
    private long timeA;
    private long timeB;
    
    private Instant start;
    private Instant stop;    
    
    public TimeInterval(){
        Date now = new Date();
        timeA = timeB = now.getTime();
        start = stop = Instant.now();
    }

    public void setTimeA(){
        Date now = new Date();
        timeA = now.getTime();
        start = Instant.now();
    }
    
    public void setTimeB(){
        Date now = new Date();
        timeB = now.getTime();
        stop = Instant.now();
    }
    
    public long getMilliSecondsDiference(){
        return timeB-timeA;
    }
    public Duration getDuration(){
		return Duration.between(start, stop);
	}
    
    public String toString(){
        long longDiff = getMilliSecondsDiference();
        long hours = longDiff / 3600000;
        longDiff = longDiff % 3600000;
        long minutes = longDiff / 60000;
        longDiff = longDiff % 60000;
        long seconds = longDiff / 1000;
        longDiff = longDiff % 1000;
        long millis = longDiff;
        return hours + " hrs:   " + minutes + " min:   " + seconds + " sec:   " + millis + " millisec"; 
    }
}


