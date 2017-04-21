import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdDraw;


/**
 *  Client for Point2D, it searches for the closest pair 
 *  of points and draws a red line between them.
 *  The amount of points must be specified on the command line.
 */
public class Point2DClient{
    private Point2DClient(){}
    
    public static void main(String[] args){
    try{
        
        int n = Integer.parseInt(args[0]);
        if(n < 2) throw new IllegalArgumentException("" + n + "");
        Point2D[] puntos = new Point2D[n];
        //StdDraw.setCanvasSize(800, 800);
        //StdDraw.setXscale(0, 100);
        //StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(0.020);        
        StdOut.println("The points are:");
        for(int p = 0; p < puntos.length; p++){
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            puntos[p] = new Point2D(x, y);
            puntos[p].draw();
            StdOut.println(puntos[p]);
        }
        
        double min2Distance = Double.MAX_VALUE;
        int indexOfPoint1 = -1, indexOfPoint2 = -1;
        for(int p1 = 0; p1 < puntos.length; p1++){
            for(int p2 = p1 + 1; p2 < puntos.length; p2++){
                double squaredDistance = puntos[p1].distanceSquaredTo(puntos[p2]);
                StdOut.println("Distance squared between " + puntos[p1] + " and " + puntos[p2] + " equals " + squaredDistance);
                if(squaredDistance < min2Distance){
                    min2Distance = squaredDistance;
                    indexOfPoint1 = p1;
                    indexOfPoint2 = p2;
                    StdOut.println("That's a minimun so far.\n");
                }
            }
        }
        StdOut.println("Distance between " + puntos[indexOfPoint1] + " and " + puntos[indexOfPoint2] + ", the closest points, equals " + puntos[indexOfPoint1].distanceTo(puntos[indexOfPoint2]));
        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.RED);
        puntos[indexOfPoint1].drawTo(puntos[indexOfPoint2]);
        
        
    }catch(ArrayIndexOutOfBoundsException aioob){
            StdOut.println("\nVictor says : Program needs a command line argument.\n");
            aioob.printStackTrace();
    }catch(NumberFormatException nf){
            StdOut.println("\nVictor says : You need to provide an INTEGER as a command line argument.\n");
            nf.printStackTrace();
    }catch(IllegalArgumentException ia){
            StdOut.println("\nVictor says : Program makes no sense for less than 2 points, " + ia.getMessage() + " not a valid argument.\n");
            ia.printStackTrace();
    }
    
    }// main  
}
