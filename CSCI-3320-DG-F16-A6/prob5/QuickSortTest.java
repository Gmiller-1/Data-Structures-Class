import java.util.Scanner;

public class QuickSortTest {

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
		
		QuickSort.sort(arr);
		
		System.out.print("\nSorted Elements: ");
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		scan.close();
		
	}

}
