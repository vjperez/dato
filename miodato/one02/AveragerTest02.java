/**
 * Reads a set of values from a text file and plots them
 * and their average.
 * Name of file containing tests scores must be supplied as command
 * line argument.
 * java  AveragerTest02 testScores.txt
 */
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Point2D;

public class AveragerTest02{
  private AveragerTest02(){}  
    
  public static void main(String[] args){  
    In in = new In(args[0]);
    double[] tests = in.readAllDoubles();
    StdDraw.setCanvasSize(1200, 700);
    StdDraw.setXscale(-1, 1 + tests.length);
    StdDraw.setYscale(-20, 120);
    StdDraw.setPenRadius(0.010);
    Averager victorAverage = new Averager("Victor Test Average");
    StdDraw.text(tests.length / 2, 110, victorAverage.getName());
    
    
    for(int testNumber = 1; testNumber <= tests.length; testNumber++){
        double testScore = tests[-1 + testNumber];
        victorAverage.addElement(testScore);
        Point2D currentTest = new Point2D(testNumber, testScore);
        Point2D testAverage = new Point2D(testNumber, victorAverage.average());
        StdDraw.setPenColor(StdDraw.BLACK);
        currentTest.draw();
        StdDraw.setPenColor(StdDraw.RED);
        if(testNumber > 1) testAverage.draw();
    }
  }
  
  
}
