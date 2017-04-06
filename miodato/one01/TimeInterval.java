import java.util.Date;

class TimeInterval{
    public TimeInterval(){
        Date now = new Date();
        timeA = timeB = now.getTime();
    }

    public void setTimeA(){
        Date now = new Date();
        timeA = now.getTime();
    }
    
    public void setTimeB(){
        Date now = new Date();
        timeB = now.getTime();
    }
    
    public long getMilliSecondsDiference(){
        return timeB-timeA;
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
    
    private long timeA;
    private long timeB;
}


