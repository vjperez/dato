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
    
    private long timeA;
    private long timeB;
}


