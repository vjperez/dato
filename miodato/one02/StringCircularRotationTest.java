import edu.princeton.cs.algs4.StdOut;

/**
 * Are 2 string circular rotations of each other?
 * 
 */
public class StringCircularRotationTest{
    private StringCircularRotationTest(){}
    
    public static void main(String[] args){
        String a = args[0];
        String b = args[1];
        
        Counter indexes = new Counter("Amount of indexes searched");
   
		if(StringCircularRotation.test(a, b, indexes)){
			StdOut.println(a + " and " + b + " are a circular rotation of each other.");
            StdOut.println(indexes);	
        }else{
			StdOut.println(a + " and " + b + " are NOT a circular rotation of each other.");
            StdOut.println(indexes);
        }
    }
}
