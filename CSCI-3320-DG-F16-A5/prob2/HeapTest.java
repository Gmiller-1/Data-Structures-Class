import java.util.Scanner;

public class HeapTest 
{

	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		System.out.println("PRIORITY QUEUE (MIN HEAP)");
		System.out.println("-------------------------------------");
		
		System.out.print("Enter Heap elements: ");
		String input = scan.nextLine();
		String[] splitElements = input.split(" ");
		
		Integer[] intArray = new Integer[splitElements.length];
		
		for(int i =0; i < splitElements.length; i++)
		{
			intArray[i] = Integer.parseInt(splitElements[i]);
		}
		
		Heap<Integer> heap = new Heap<Integer>(intArray);
		
		System.out.print("Output: Heap (d=2): ");
		heap.printHeap();
		
		while(choice != 5)
		{
		System.out.println("-------------------------------------");
		System.out.println("Press 1) for insert, 2) for deleteMin, 3) Remove, 4) Change Value, 5) to quit");
		System.out.print("\n Enter Choice: ");
		
		choice = scan.nextInt();
		
		switch(choice)
		{
		case 1: System.out.print(" Enter element to insert: ");
				heap.insert(scan.nextInt());
				System.out.println("\nOutput Heap: ");
				heap.printHeap();
				break;
			
		case 2: heap.deleteMin();
				System.out.print("Output Heap: ");
				heap.printHeap();
				break;
			
		case 3:	System.out.print("Enter key to remove: ");
				Integer key = scan.nextInt();
				heap.remove(key);
				System.out.print("\nOutput Heap: ");
				heap.printHeap();
				break;
				
		case 4: System.out.print("Enter the key to change: ");
				Integer keyToChange = scan.nextInt();
				System.out.print("\nEnter key to change to: ");
				Integer toChangeTo = scan.nextInt();
				heap.changeValue(keyToChange, toChangeTo);
				System.out.print("\nOutput Heap: ");
				heap.printHeap();
				break;
				
		case 5: System.out.println("\nGood bye");
				break;
		}
	}
	}

}
