import java.util.Scanner;

public class TestDeque 
{
	public static void main(String[] args) 
	{
		Deque<Integer> listicle = new Deque<Integer>();
		
		int choice;
		do
		{
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter operation for dequeue (1: Push, 2: Pop, 3: Inject, 4: Eject, 5: Quit): ");
			choice = scan.nextInt();
			switch(choice)
			{
				
				case 1: System.out.print("Enter element to push: ");
						int pushElement = scan.nextInt();
						listicle.push(pushElement);
						System.out.print("Current Deque: " + listicle.toString());
						System.out.println();
						break;
				
				case 2: if(listicle.isEmpty())
						{
							System.out.println("Deque is empty, nothing to pop");
						}
						else
						{
							listicle.pop();
							System.out.print("Current Deque: " + listicle.toString());
							System.out.println();
						}
						break;
				
				case 3: System.out.print("Enter element to inject: ");
						int injectElement = scan.nextInt();
						listicle.inject(injectElement);
						System.out.print("Current Deque: " + listicle.toString());
						System.out.println();
						break;
				
				case 4: if(listicle.isEmpty())
						{
							System.out.println("Deque is empty, nothing to eject");
						}
						else
						{
							listicle.eject();
							System.out.print("Current Deque: " + listicle.toString());
							System.out.println();
						}
						break;
				
				case 5: System.out.println("G'Bye!");
						System.exit(0);
			}
		}while(choice != 0);
	}

}
