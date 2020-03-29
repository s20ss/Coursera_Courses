import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints=getNumPoints(s);
        double averageLength=getAverageLength(s);
        double largestSide=getLargestSide(s) ;
        double largestX=getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("Number of Points = " + numPoints);
        System.out.println("Average Length of a Side = " + averageLength);
        System.out.println("Largest Side of the shape = " + largestSide);
        System.out.println("Largest X value of the shape = " + largestX);
    }
    public int getNumPoints(Shape s){
        int numPoints=0;
        for (Point p:s.getPoints()){
            numPoints=numPoints+1;
        }
        return  numPoints;
    }
    public double getAverageLength(Shape s){
        double averagelength=0.0;
        double perimeter=getPerimeter(s);
        int numPoints=getNumPoints(s);
        averagelength=perimeter/numPoints;
        return averagelength;


    }

    public double getLargestSide(Shape s){
        double largestSide = 0.0;
        // Start wth prevPt = the last point
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            if(currDist>largestSide){
                largestSide=currDist;
            }
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        return  largestSide;

    }
    public double getLargestX(Shape s){
        double  largestX=0.0;
        double currx=0.0;
        Point prev=s.getLastPoint();
        double prevx=prev.getX();
        for (Point p:s.getPoints()){
            currx=p.getX();
            if(currx>prevx){

                prevx=currx;
            }


        }
        return  prevx;
    }

    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();

    }
}
