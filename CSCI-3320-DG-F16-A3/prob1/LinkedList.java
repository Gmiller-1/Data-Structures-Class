/*
Name        :Gary Miller
Class       :1620-850
Program #   :#4
Due Date    :March 21, 2016

Honor Pledge: On my honor as a student of the University
              of Nebraska at Omaha, I have neither given nor recieved
              unauthorized help on this homework assignment

NAME: Gary Miller
NUID: 079
EMAIL: Garymiller@unomaha.edu

Partners: NONE

This program will keep track of employees for a business
*/  



import exceptions.EmptyListException;

public class LinkedList<E extends Comparable<E>>
{
	private ListNode<E> firstNode; 
	private ListNode<E> lastNode;
	private int numElements;
	private String name;
	
	
	public LinkedList()
	{
		firstNode = null;
		lastNode = null;
		numElements = 0;
	}
	
	public LinkedList(String name)
	{
		firstNode = null;
		lastNode = null;
		numElements = 0;
		this.name = name;
	}
	
	//Method Name       :insertAtFront
    //Parameters        :item, E
    //Return value(s)   :None
    //Partners          :None
    //Description       :insert item at front of linked list
	public void insertAtFront(E item)
	{
		
		if(isEmpty())
		{
			ListNode<E> insert = new ListNode<E>(item);
			firstNode = insert;
			lastNode = insert;
			numElements++;
		}	
		else if(!isEmpty())
		{
			ListNode<E> insert = new ListNode<E>(item);
			insert.setNext(firstNode);
			firstNode = insert;
			numElements++;
		}
	}
	
	//Method Name       :insertAtBack
    //Parameters        :item E
    //Return value(s)   :None
    //Partners          :None
    //Description       :insert item at back of linked list
	public void insertAtBack(E item)
	{
		if(isEmpty())
		{
			ListNode<E> insert = new ListNode<E>(item);
			firstNode = insert;
			lastNode = insert;
			numElements++;
		}
		else if(!isEmpty())
		{
			ListNode<E> insert = new ListNode<E>(item);
			lastNode.setNext(insert);
			lastNode = insert;
			numElements++;
		}
	}
	
	//Method Name       :removeFromFront
    //Parameters        :None
    //Return value(s)   :E
    //Partners          :None
    //Description       :remove item from front of linked list
	public E removeFromFront() throws EmptyListException
	{
		E firstNodeCopy;
		
		if(firstNode == null)
		{
			throw new EmptyListException(name + " ");
		}
		else if(firstNode == lastNode)
		{
			firstNodeCopy = firstNode.getData();
			firstNode = null;
			lastNode = null;
			numElements--;
		}
		else 
		{
			firstNodeCopy = firstNode.getData();
			firstNode = firstNode.getNext();
			numElements--;
		}
		return firstNodeCopy;
	}
	
	//Method Name       :removeFromBack
    //Parameters        :None
    //Return value(s)   :E
    //Partners          :None
    //Description       :removes item from back of linked list
	public E removeFromBack() throws EmptyListException
	{
		E lastNodeCopy;
		ListNode<E> current = firstNode;
		if(isEmpty())
		{
			throw new EmptyListException(name + " ");
		}	
		else if(firstNode == lastNode)
		{
			lastNodeCopy = lastNode.getData();
			firstNode = null;
			lastNode = null;
			numElements--;
		}
		else
		{
			lastNodeCopy = lastNode.getData();
			while(current.getNext() != lastNode)
			{
				current = current.getNext();
			}
			current.setNext(null);
			lastNode = current;
			numElements--;
		}
		return lastNodeCopy;
	}
	
	
	//Method Name       :removeItem
    //Parameters        :index, int
    //Return value(s)   :E
    //Partners          :None
    //Description       :removes specific index from linked list
	public E removeItem(int index) throws IndexOutOfBoundsException
	{	
		ListNode<E> toRemove = new ListNode<E>(null);
		ListNode<E> current = firstNode;
		E data = null;
		
		if(index < 0 || index >= numElements)
		{
			throw new IndexOutOfBoundsException(name + " Index out of Range");
		}
		else if(index == 0)
		{
			data = firstNode.getData();
			removeFromFront();
			numElements--;
		}
		else if(index == numElements)
		{
			data = lastNode.getData();
			removeFromBack();
			numElements--;
		}
		else
		{
			int count = index;
			while(count > 1)
			{
				current = current.getNext();
				count--;
			}
			
			data = current.getNext().getData();
			toRemove = current.getNext();
			current.setNext(toRemove.getNext());
			numElements--;
			
		}
		return data;
	}
	
	
	//Method Name       :getItem
    //Parameters        :index int
    //Return value(s)   :E
    //Partners          :None
    //Description       :get item at index
	public E getItem(int index) throws IndexOutOfBoundsException
	{
		ListNode<E> current = firstNode;
		E data = null;
		
		if(index < 0 || index > lengthIs() - 1)
		{
			throw new IndexOutOfBoundsException(name + " Index out of Range");
		}
		else if(index == 0)
		{
			data = firstNode.getData();
		}
		else if(index == lengthIs() - 1)
		{
			data = lastNode.getData();
		}
		else
		{
			int count = index;
			while(count > 1)
			{
				current = current.getNext();
				count--;
			}
			
			data = current.getNext().getData();
			
		}
		return data;
		
	}
	
	
	//Method Name       :setItem
    //Parameters        :index, item
    //Return value(s)   :E
    //Partners          :None
    //Description       :puts item in index of linked list
	public E setItem(int index, E item) throws IndexOutOfBoundsException
	{
		ListNode<E> current = firstNode;
		E data = null;
		
		if(index < 0 || index >= lengthIs())
		{
			throw new IndexOutOfBoundsException(name + " Index out of Range");
		}
		if(index == 0)
		{
			//System.out.println("settting first NOOOOOOOOODDDE");
			data = firstNode.getData();
			firstNode.setData(item);
		}
		if(index == lengthIs() - 1)
		{
			//System.out.println("setting last NODEEEEEE");
			data = lastNode.getData();
			lastNode.setData(item);
		}
		else
		{
			int count = index;
			while(count > 1)
			{
				current = current.getNext();
				count--;
			}
			data = current.getData();
			current.setData(item);
			
		}
		return data;
		
	}
	
	
	//Method Name       :findAndRemove
    //Parameters        :item
    //Return value(s)   :Boolean
    //Partners          :None
    //Description       :find item in linked list and remove
	public Boolean findAndRemove(E item)
	{
		Boolean wasRemoved = false;
		
		int index = findItem(item);
		
		if(index >= 0) 
		{
			removeItem(index);
			wasRemoved = true;
		}
		return wasRemoved;
		
	}
	
	
	//Method Name       :findItem
    //Parameters        :item
    //Return value(s)   :int
    //Partners          :None
    //Description       :find item in linked list
	public int findItem(E item)
	{
		Boolean found = false;
	
		ListNode<E> current = firstNode;
		int index = -1;
		
		while(current.getNext() != null && !found)
		{
			index++;
			//System.out.println("CURRENT DATA: " + current.getData() + "      " + "COMPARE TO: " + item);
			if(current.getData().compareTo(item) == 0)
			{
				found = true;
				//System.out.println("INDEX: " + index);
			}
			else
			{
				current = current.getNext();
			}
		}
		
		if(!found) 
		{
			index = -1;
		}
		return index;
	}
	
	
	//Method Name       :lengthIs
    //Parameters        :None
    //Return value(s)   :int
    //Partners          :None
    //Description       :returns length of linked list
	public int lengthIs()
	{
		//return numElements;
		
		int count = 0;
		
		ListNode<E> current = firstNode;
		
		while(current != null)
		{
			current = current.getNext();
			count++;
		}
				
		return count;
		
	}
	
	//Method Name       :clear
    //Parameters        :None
    //Return value(s)   :None
    //Partners          :None
    //Description       :clears the linked list
	public void clear()
	{
		firstNode = null;
		lastNode = null;
		numElements = 0;
	}
	
	
	//Method Name       :toString
    //Parameters        :None
    //Return value(s)   :String
    //Partners          :None
    //Description       :returns string of all elements of linked list
	public String toString()
	{
		ListNode<E> current = firstNode;
		String result = "";
		
		while(current != null)
			{
				result = result + current.getData().toString() + "\n\n";
				current = current.getNext();
			}
	
		//result += current.toString();
		return result;
	}
	
	
	//Method Name       :isEmpty
    //Parameters        :None
    //Return value(s)   :None
    //Partners          :None
    //Description       :checks if linked list is empty
	public Boolean isEmpty()
	{
		Boolean answer;
		if(lengthIs() == 0)
		{
			answer = true;
		}
		else
		{
			answer = false;
		}	
		return answer;
	}
	
	//Method Name       :sort
    //Parameters        :None
    //Return value(s)   :None
    //Partners          :None
    //Description       :sorts the linked list
	public void sort() throws EmptyListException
	{
		ListNode<E> unsorted, min, pointer;
		E tempMin;
		
		unsorted = firstNode;
		
		if(isEmpty()){
			throw new EmptyListException(name + " ");
		}
		while(unsorted != null)
		{
			min = unsorted;
			pointer = unsorted;
			
			while(pointer != null)
			{
				if(pointer.getData().compareTo(min.getData()) == -1)
				{
					min = pointer;
					pointer = pointer.getNext();
				}
				else
				{
					pointer = pointer.getNext();
				}
			}
			tempMin = min.getData();
			min.setData(unsorted.getData());
			unsorted.setData(tempMin);
			unsorted = unsorted.getNext();
			
		}
	}
}






















