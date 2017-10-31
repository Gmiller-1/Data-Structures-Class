public class Deque<E extends Comparable<E>>
{
	private LinkedList<E> list;
	
	// CONSTRUCTOR
	public Deque()
	{
		list = new LinkedList<E>();
	}
	////////////////
	
	public void push(E item)
	{
		list.insertAtFront(item);
	}
	
	public E pop()
	{
		E data = null;// = list.get(0);
		if(!list.isEmpty())
		{
			data = list.removeFromFront();
		}
		return data;
	}
	
	public void inject(E item)
	{
		list.insertAtBack(item);
	}
	
	public E eject()
	{
		E data = list.removeFromBack();
		return data;
	}
	
	// returns length of deque
	public int lengthIs()
	{
		int length = list.lengthIs();
		return length;
	}
	
	// looks at first item in deque
	public E peek()
	{
		E peekAt = list.getItem(0);
		return peekAt;
	}
	
	// return string of all deque members
	public String toString()
	{
		String toSend = "";
		for(int i=0; i < list.lengthIs(); i++)
		{
			toSend += list.getItem(i) + " ";
		}
		return toSend;
	}
	
	// checks if queue is empty
	public Boolean isEmpty()
	{
		Boolean answer;
		if(list.lengthIs() == 0)
		{
			answer = true;
		}
		else
		{
			answer = false;
		}	
		return answer;
	}	
}
