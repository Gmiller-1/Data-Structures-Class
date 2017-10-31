
public class Stack 
{
	private char[] stackArr;
	private int arrSize;
	private int top;
	
	public Stack(int x)
	{
		arrSize = x;
		stackArr = new char[arrSize];
		top = -1;
	}
	
	public void push(char x)
	{
		stackArr[++top] = x;
	}
	
	public char pop()
	{
		return stackArr[top--];
	}
	
	public int peek()
	{
		return stackArr[top];
	}
	
	public boolean isEmpty()
	{
		return (top == -1);
	}
	
	
}
