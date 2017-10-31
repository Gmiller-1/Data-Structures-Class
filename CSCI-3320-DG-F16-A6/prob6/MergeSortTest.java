import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MergeSortTest 
{
	static coPointArray[] coPointArr = null;
	
	public static void main(String[] args) throws FileNotFoundException 
	{
		String nums = null;
		try 
		{
			Scanner reader = new Scanner(new File("points.txt"));
			
			while(reader.hasNextLine())
			{
				nums = reader.nextLine();
				nums = nums.replaceAll("[(,)]", "");
			}
			reader.close();
		} 
		catch (IOException e) 
		{
			System.out.println("File Read Error");
		}
		
		
		String[] preNumArray = nums.split(" ");
		int[] numArray = new int[preNumArray.length];
		
		for(int d = 0; d < preNumArray.length;d++)
		{
			numArray[d] = Integer.parseInt(preNumArray[d]);
		}
		
		int numPoints = (numArray.length+1)/2;
		
	    Point[] points = new Point[numPoints];
	    
		int evenCount = 0;
		int oddCount = 1;
		for(int k = 0; k <= numPoints - 1; k++)
		{
			int x = numArray[evenCount];
	        int y = numArray[oddCount];
	        points[k] = new Point(x, y);
	        evenCount+=2;
	        oddCount+=2;
		}
		
		////
		///	Prints all the points
		//
		System.out.println("All The Points: ");
		for(int y=0; y<points.length;y++)
		{
			System.out.print(points[y]);
		}
		System.out.println();
		////////////////////////////////////////
		
		// Set up an array for collinear points
		coPointArr = new coPointArray[points.length];
		
		// Extra array of points to keep reference to original
		Point[] temp = points;
		double tempSlope = 0;
		
		for(int p = 0; p < numPoints; p++)
		{
			// Sort points by slope compared to element at index i
			MergeSort.sort(points, points[p].SLOPE_ORDER);
			
			ArrayList<Point> coPoints = new ArrayList<Point>(numPoints);
			Set<Double> set = new HashSet<Double>();
			Boolean added = false;
			for (int q = 1; q < numPoints ; q++) 
			{
				//System.out.print("Checking points " + points[0].toString() + " with " + temp[q].toString());
				//System.out.println("       SLOPE: " + points[0].slopeOf(temp[q]));
				if (p == q) 
				{
					continue;
	            }
				
				if(!set.add(points[0].slopeOf(temp[q]))&& points[0].slopeOf(points[q]) != Double.POSITIVE_INFINITY)
				{
					if(points[0].slopeOf(points[q]) <= points[0].slopeOf(points[q-1]) && !added)
					{
						coPoints.add(points[q-1]);
						//System.out.println("--------ADDED: " +points[q-1] + "----------");
						added = true;
					}
					coPoints.add(temp[q]);
					//System.out.println("--------ADDED: " +temp[q] + "----------");
					tempSlope = points[0].slopeOf(points[q]);
				}
			}
			coPoints.add(points[0]);
			//System.out.println("--------ADDED: " +points[0] + "----------");
			//System.out.println();
			
			if(coPoints.size() > 3)
			{
				coPointArr[p] = new coPointArray(coPoints.size(), coPoints, tempSlope);
			}
		}
		System.out.println("________________________________________________________________________");
		//System.out.println(coPointArr[0].print());
		//System.out.println(coPointArr[1].print());
		//System.out.println(coPointArr[2].print());
		//System.out.println(coPointArr[3].print());
		//System.out.println(coPointArr[4].print());
		//System.out.println(coPointArr[5].print());
		printPoints();
		
	}
	
	public static void printPoints()
	{
		int count = 0;
		Set<Double> set = new HashSet<Double>();
		coPointArray[] temp = coPointArr;
		
		for(int i =0; i < coPointArr.length; i++)
		{
			if(coPointArr[i] == null)
			{
				continue;
			}
			if(set.add(coPointArr[i].slope) == true)
			{
				temp[count] = coPointArr[i];
				count++;
			}
		}
		System.out.println("Found " + (count) + " sets of four or more collinear points:");
		for(int j = 0; j < count; j ++)
		{
			System.out.print("Set " + (j+1) + " (" + temp[j].size + " points): ");
			System.out.println(temp[j].print());   ///////////////// + "     SLOPE: " + temp[j].slope );
		}
	}
}









































