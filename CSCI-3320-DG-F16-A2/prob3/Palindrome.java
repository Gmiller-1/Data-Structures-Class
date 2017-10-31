import java.util.Scanner;

public class Palindrome 
{
	static String reversedString = "";
	static String inputStr = "";
	static String newStr = "";
	static char[] tempArray;
	
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
	    
		System.out.print("Enter a string to test for palindrome: ");
	    inputStr = scan.nextLine().toLowerCase();
	    
	    Stack stack = new Stack(inputStr.length()+1);

	    
	    for(int i = 0; i < inputStr.length(); i++)
	    {
	    	int ascii = (int) inputStr.charAt(i);
	    	String str = Character.toString(inputStr.charAt(i));
	    	if(ascii >= 97 && ascii <= 122)
	    	{
	    		stack.push(inputStr.charAt(i)); 
	    		newStr += str;
	    	}
	    }
	    
	    while(!stack.isEmpty())
	    {
	    	char letter = stack.pop();
	    	reversedString += letter;
	    }
	    
	    System.out.println("Reverse string is: " + reversedString);
	    
	    
	    if(reversedString.equalsIgnoreCase(newStr))
	    {
	    	System.out.println("Input string is a palidrome");
	    }
	    else
	    {
	    	System.out.println("Input string is not a palindrome");
	    }
	}
}











