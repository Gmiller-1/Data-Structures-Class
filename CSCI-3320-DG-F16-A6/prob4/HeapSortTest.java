import java.util.Scanner;

public class HeapSortTest {

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter list of elements to sort (separated by spaces): ");
		String[] input = scan.nextLine().split(" ");
		Integer[] arr = new Integer[input.length];
		
		for(int i =0; i < input.length; i++)
		{
			arr[i] = Integer.parseInt(input[i]);
		}
		
		System.out.print("Enter lower bound of range to sort: ");
		int lowerBound = scan.nextInt();
		System.out.print("Enter upper bound of range to sort: ");
		int upperBound = scan.nextInt();
		
		HeapSort.heapsort(arr, lowerBound, upperBound);
		//HeapSort.heapSort2(arr, arr.length, lowerBound, upperBound);
		
		System.out.print("\nSorted Elements: ");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		
		scan.close();
	}

}
