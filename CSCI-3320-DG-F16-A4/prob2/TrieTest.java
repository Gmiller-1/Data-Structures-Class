import java.util.Scanner;

public class TrieTest 
{
	static TernaryTree tree = new TernaryTree();
	static int valCount = 0;

	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		
		do
		{
			System.out.println("--------------------------------------------------");
			System.out.println(">> Enter choice [1-4] from menu:");
			System.out.println("  1) Insert String \n"
					+ "  2) Find String \n"
					+ "  3) Print Trie (Level Order Traversal) \n"
					+ "  4) Exit");
			System.out.print("\nchoice: ");
			choice = scan.nextInt();
			System.out.println();
			
			switch(choice)
			{
			case 1: int size = valCount;
					System.out.print("Enter String to Insert: ");
					String toInsert = scan.next();
					tree.insert(toInsert, size );
					valCount++;
					break;
					
			case 2: System.out.print("Enter String to Search: ");
					String toFind = scan.next();
					if(tree.fetch(toFind) == 0)
					{
						System.out.println("String '" + toFind + "' not found");
					}
					else
					{
						System.out.println("String '" + toFind + "' found");
					}
					break;
					
			case 3: System.out.println("Level Order Traversal: ");
					tree.levelOrderPrint();
					break;
					
			case 4: System.out.println("G'bye");
			}
			
		}while(choice != 4);
		
	}

}
