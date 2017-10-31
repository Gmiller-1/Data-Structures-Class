import java.util.Scanner;
 
public class BucketSort
{
	public final static int RADIX = 10;
	
	 	///////////////////////
        // MAIN PROGRAM AREA //
        ///////////////////////
    public static void main(String args[]) 
    {
    	Scanner scan = new Scanner(System.in);
        
    	System.out.println("Enter the list of integers to be sorted, separated by black spaces: ");
        
        String lineOfNumbers = "8178 32 315 19 45921 7130 4 563 1999 390 2873 431";//scan.nextLine();
        String[] splitText = lineOfNumbers.split(" ");
        int[] numbers = new int[splitText.length];
        
        for(int i = 0; i < splitText.length; i++)
        {
        	numbers[i] = Integer.parseInt(splitText[i]);
        }
        
        
        System.out.print("List: ");
        for(int m = 0; m<numbers.length; m++)
        {
        	System.out.print(numbers[m] + " ");
        }
        System.out.println();
       
        int maxValue = maxValue(numbers);
        //System.out.println("\nMAX VALUE: " + maxValue);
        
        sort(numbers, maxValue);
        
    }
    
    
    	///////////////////
    	/// SORT METHOD ///
    	///////////////////
	public static void sort(int[] a, int maxDigit)
	{
    	Object[] buckets = new Object[100];
    	LinkedList<Integer> lst = new LinkedList<Integer>();
    	
    	int numDigits = String.valueOf(10000).length();
    	System.out.println("\nNumber of passes required: " + numDigits + "\n");
    	
    	// Initialize the Linked List for each bucket
    	for(int b = 0; b < 10; b++)
    	{
    		buckets[b] = lst;
    	}

    	for(int i = 2; i <= numDigits; i+=2 )	// Iterate through each digit up to MAX
    	{
    		
    		for(int j = 1; j < a.length; j++)	// Iterate through each number in array 
    		{
    			// k = least sig fig of each number in array
    			int k = (int) ((a[j]%(Math.pow(10, i)))/Math.pow(10, (i-1)));
    			// add number to bucket with key = sig fig 
    			buckets[k] = a[j];
    			//lst.insertAtFront(a[j]);
    		}
    		
    		//for(int p = 0; p < buckets.length; p++)
    		//{
    		//	a[p] = lst.removeFromFront();
    		//}
    		
    		System.out.println("Pass " + i + " buckets are: ");
    		for(int t = 0; t < buckets.length; t++)
    		{
    			Object nums = buckets[t];
    			System.out.print(t + ": "+ nums+ " \n");
    		
    		}
    		System.out.println();
    	}
    	
         
    	
	}
    
    
    //////////////////////////////////////////////////////////
    // Method for finding max value in initial number array //
    //////////////////////////////////////////////////////////
    static int maxValue(int[] sequence) 
	{
		int maxValue = 0;
		for (int i = 0; i < sequence.length; i++)
		{
			if (sequence[i] > maxValue)
			{
				maxValue = sequence[i];
			}
		}
		return maxValue;
	}
}