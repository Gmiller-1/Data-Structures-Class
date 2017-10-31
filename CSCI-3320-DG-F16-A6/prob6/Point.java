import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
	
	 // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeOrder();
    
    private final int x;                              // x coordinate
    private final int y;                              // y coordinate
    
    private class SlopeOrder implements Comparator<Point> 
    {
        public int compare(Point point1, Point point2) {
            // Calculate the slope of the point <this> points to with the <point1>
            double slope1 = slopeOf(point1);
            
            // Calculate the slope of the point <this> point to with the <point2>
            double slope2 = slopeOf(point2);
            
            return Double.compare(slope1, slope2);
        }
    }
	
	/*
	public Comparator<Point> slopeOrder() 
	{
        return new Comparator<Point>() 
        {
            @Override
            public int compare(Point point1, Point point2)
            {
                double slopeDiff = slopeOf(point1) - slopeOf(point2);
                if (slopeDiff > 0) {
                    return 1;
                } else if (slopeDiff < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        };
	}

    private final int x;    // x coordinate
    private final int y;    // y coordinate

*/
    // create the point (x, y)
    public Point(int x, int y) 
    {
        this.x = x;
        this.y = y;
    }

    // slope between this point and that point
    public double slopeOf(Point that) 
    {
        if (that == null) 
        {
            System.out.println("Null pointer Exception");
        }
        if (that.x == x) 
        {
            if (that.y == y) 
            {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.POSITIVE_INFINITY;
        }
        if (that.y == y) 
        {
            return 0.0;
        }
        return (double) (that.y - this.y) / (that.x - this.x);
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) 
    {
        if (y == that.y && x == that.x) 
        {
            return 0;
        }
        if (y < that.y || (y == that.y && x < that.x)) 
        {
            return -1;
        }
        return 1;
    }

    // return string representation of this point
    public String toString() 
    {
        return "(" + x + ", " + y + ")";
    }
}
