import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class coPointArray 
{
	ArrayList<Point> pointsArr;
	int size;
	double slope;
	
	public coPointArray(int size,ArrayList<Point> coPoints, double d)
	{
		pointsArr = new ArrayList<Point>(size);
		addPoints(coPoints);
		this.size = size;
		this.slope = d;
	}
	public coPointArray(int size,ArrayList<Point> coPoints)
	{
		pointsArr = new ArrayList<Point>(size);
		addPoints(coPoints);
		this.size = size;
	}
	
	public void addPoints(ArrayList<Point> coPoints)
	{
		pointsArr.addAll(coPoints);
	}
	
	public ArrayList<Point> getPoints()
	{
		return pointsArr;
	}
	
	public String print()
	{
		String toSend = "";
		for(int i =0; i < pointsArr.size(); i++)
		{
			toSend += pointsArr.get(i) + " ";
		}
		return toSend;
	}
	
}
