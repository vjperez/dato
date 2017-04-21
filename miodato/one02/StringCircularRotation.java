/**
 * Are 2 string circular rotations of each other?
 * 
 */
public class StringCircularRotation{
    private StringCircularRotation(){}
    
    public static boolean test(String a, String b, Counter c){
        int index = a.indexOf(b.substring(0,1), 0);
        while(index > -1 && index < a.length()){
            c.increase();
			if( b.equals(a.substring(index, a.length()) + a.substring(0, index)) ){
				return true;
			}else{
				index = a.indexOf(b.substring(0,1), index + 1);
			}
		}	
		return false;
    }
}
