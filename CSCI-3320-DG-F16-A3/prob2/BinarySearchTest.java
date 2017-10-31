import java.util.Scanner;

public class BinarySearchTest {
	
	static BinarySearchTree bsTree = new BinarySearchTree();

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		do
		{
		System.out.println("\n--------------------------------------");
		System.out.println(">> Enter choice [1-7] from menu below: \n");
		System.out.println("   1) Insert node \n"
				+ "   2) Print tree (in-order)\n"
				+ "   3) Print number of leaves in tree\n"
				+ "   4) Print the number of nodes in T that contain only one child\n"
				+ "   5) Print the number of nodes in T that contain only two children\n"
				+ "   6) Print the level order traversal of the tree\n"
				+ "   7) Exit program");
		System.out.print("\nchoice: ");
		choice = scan.nextInt();
		System.out.println();
		
		switch(choice)
		{
		case 1: System.out.print("Enter Node Value: ");
				int nodeVal = scan.nextInt();
				bsTree.insert(nodeVal);
				break;
				
		case 2: bsTree.printTree();
				break;
				
		case 3: int leafCount = bsTree.numLeaves();
				System.out.print("# of leaves in tree: " + leafCount);
				break;
			
		case 4: int numOneChilds = bsTree.numOneChildNodes();
				System.out.print("# of nodes with one child: " + numOneChilds);
				break;
				
		case 5: int numTwoChilds = bsTree.numTwoChildrenNodes();
				System.out.print("# of nodes with two children: " + numTwoChilds);
				break;
				
		case 6: System.out.println("Level order traversal: ");
				bsTree.levelOrder();
				break;
		
		case 7: System.out.println("G'bye");
		}
		}while(choice != 7);
		
		
	}

}
