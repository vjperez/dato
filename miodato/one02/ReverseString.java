
public class ReverseString{

private ReverseString(){}
    
    public static String reverse(String str){
        int N = str.length();
        if (N == 1 || N == 0) return str; // reverse of empty string is itself !?
        else return reverse(str.substring(N/2, N)) + reverse(str.substring(0, N/2));
    }

}
