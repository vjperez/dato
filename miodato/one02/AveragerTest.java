/**
 * Reads a set of values from standard input (java  AveragerTest < testScores.txt) and plots them
 * and their average.
 */
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.Point2D;

public class AveragerTest{
  private AveragerTest(){}  
    
  public static void main(String[] args){  
    double testScore;
    final int maxNumberOfTests = 20; 
    int testNumber = 0;
    Averager victorAverage = new Averager("victor test average");
    
    StdDraw.setCanvasSize(1200, 700);
    StdDraw.setXscale(0, maxNumberOfTests);
    StdDraw.setYscale(-20, 120);
    StdDraw.setPenRadius(0.010);
    
    
    while( ! StdIn.isEmpty()){
        testScore = StdIn.readDouble();
        testNumber++;
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
