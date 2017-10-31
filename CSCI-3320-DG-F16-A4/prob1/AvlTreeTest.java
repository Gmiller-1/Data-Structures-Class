import java.util.Scanner;

public class AvlTreeTest 
{
	static AvlTree tree = new AvlTree();

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		do
		{
			System.out.println("--------------------------------------------");
			System.out.println(">> Enter choice [1-4] from menu: ");
			System.out.println("  1) Insert Node \n"
					+ "  2) Remove Node \n"
					+ "  3) Print Tree (Level Order Traversal) \n"
					+ "  4) Exit");
			System.out.print("\nchoice: ");
			choice = scan.nextInt();
			System.out.println();
			
			switch(choice)
			{
			case 1: System.out.print("Enter Node Value: ");
					int nodeVal = scan.nextInt();
					tree.insert(nodeVal);
					break;
					
			case 2: System.out.print("Enter Node To Delete: ");
					int nodeToDel = scan.nextInt();
					tree.remove(nodeToDel);
					break;
					
			case 3: System.out.println("Level Order Traversal: ");
					tree.levelOrderPrint();
					break;
					
			case 4: System.out.println("G'bye");
			}
			
		}while(choice != 4);
	}

}
