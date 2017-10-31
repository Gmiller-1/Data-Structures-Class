
import java.util.Scanner;

public class DheapTest {
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		System.out.print("Enter Heap elements: ");
		String input = scan.nextLine();
		String[] splitElements = input.split(" ");
		
		Integer[] intArray = new Integer[splitElements.length];
		
		for(int i =0; i < splitElements.length; i++)
		{
			intArray[i] = Integer.parseInt(splitElements[i]);
		}
		
		System.out.print("Enter d: ");
		int d = scan.nextInt();
	
		dHeap heap = new dHeap(intArray, d);
		
		
		System.out.print("Output: Heap (d=" + d + "): ");
		heap.printHeap();
		
		while(choice != 4)
		{
		System.out.println("-------------------------------------");
		System.out.println("Press 1) for insert, 2) for deleteMin, 3) for new d value, 4) to quit");
		System.out.print("\n Enter Choice: ");
		
		choice = scan.nextInt();
		
		switch(choice)
		{
		case 1: System.out.println("Enter element to insert: ");
				heap.insert(scan.nextInt());
				System.out.println("Output: Heap (d=" + d + "): ");
				heap.printHeap();
				break;
			
		case 2: heap.deleteMin();
				System.out.println("Output: Heap (d=" + d + "): ");
				heap.printHeap();
				break;
			
		case 3:	System.out.print("Enter d: ");
				d = scan.nextInt();
				heap.setD(d);
				heap.buildHeap();
				System.out.println("Output: Heap (d=" + d + "): ");
				heap.printHeap();
				break;
			
		case 4: System.out.println("Good bye");
				break;
		}
			
		}
	}

}
