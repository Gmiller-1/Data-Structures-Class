/*
Name        : Gary Miller
Class       : 1620-850
Program #   : #4
Due Date    : March 21, 2016

Honor Pledge:  On my honor as a student of the University
               of Nebraska at Omaha, I have neither given nor recieved
               unauthorized help on this homework assignment.

NAME: Gary Miller
NUID: 079
EMAIL: Garymiller@unomaha.edu

Partners: NONE

This program keeps track of employees for a business
*/   

import exceptions.InvalidSizeException;
import exceptions.MaximumCapacityException;

public class ArrayList<E extends Comparable<E>>
{
	private final int DEFCAP = 50;
	private int origcap;
	private int numElements = 0;
	private Object[] list;
	
	//Default constructor
	public ArrayList()
	{
		numElements = 0;
		origcap = DEFCAP;
		list = new Object[origcap];
	}
	
	//Constructor with arguments
	public ArrayList(int size) throws InvalidSizeException
	{
		numElements = 0;
		if(size >= 1 && size <= DEFCAP)
		{
			origcap = size;
			list = new Object[origcap];
		}
		else
		{
			throw new InvalidSizeException();
		}
	}	
	
	
	//Method Name       :addItem
    //Parameters        :item, E
    //Return value(s)   :None
    //Partners          :None
    //Description       :adds an item to array at position index
	public void addItem(E item) throws MaximumCapacityException
	{
		if(numElements == origcap)
		{
			enlarge();
			list[numElements] = item;
			numElements++;
			MaximumCapacityException e = new MaximumCapacityException();
			throw e;
		}
		else
		{
			list[numElements] = item;
			numElements++;
		}
	}
	
	
	//Method Name       :getItem
    //Parameters        :index, int
    //Return value(s)   :E
    //Partners          :None
    //Description       :returns an item from the array
	@SuppressWarnings("unchecked")
	public E getItem(int index) throws IndexOutOfBoundsException
	{
		if(index <= numElements && index >= 0)
		{
			return (E) list[index];
		}
		else
		{
			throw new IndexOutOfBoundsException("Index out of Range");
		}
	}
	
	
	//Method Name       :setItem
    //Parameters        :index, item. int, E
    //Return value(s)   :None
    //Partners          :None
    //Description       :sets an item in the array
	public void setItem(int index, E item) throws IndexOutOfBoundsException
	{
		if(index <= numElements && index >= 0)
		{
			list[numElements] = item;
		}
		else
		{
			IndexOutOfBoundsException e = new IndexOutOfBoundsException("Index out of Range");
			throw e;
		}
	}
	
	
	//Method Name       :removeItem
    //Parameters        :index, int
    //Return value(s)   :None
    //Partners          :None
    //Description       :removes item from array given index
	public void removeItem(int index) throws IndexOutOfBoundsException
	{
		if(index <= numElements && index >= 0)
		{
			while(this.getItem(numElements--) == null)
			{
				list[index] = list[numElements];
			}
		}
		else
		{
			throw new IndexOutOfBoundsException("Index out of Range");
		}
	}
	
	
	//Method Name       :findItem
    //Parameters        :item, E
    //Return value(s)   :int
    //Partners          :None
    //Description       :checks whether an employee entry is the same as another
	public int findItem(E item)
	{
		int position = -1;
		
		for(int i = 0; i < numElements; i ++)
		{
			if(list[i] == item)
			{
				position = i;
				break;
			}
		}
		return position;
	}
	
	
	//Method Name       :isEmpty
    //Parameters        :None
    //Return value(s)   :Boolean
    //Partners          :None
    //Description       :returns true if array is empty
	public Boolean isEmpty()
	{
		if(numElements == 0)
		{
			return true;
		}
		else	
		return false;
		
	}
	
	
	//Method Name       :lengthIs
    //Parameters        :None
    //Return value(s)   :int
    //Partners          :None
    //Description       :returns length of array as number of elements
	public int lengthIs()
	{
		return numElements;
	}
	
	
	//Method Name       :clear
    //Parameters        :None
    //Return value(s)   :None
    //Partners          :None
    //Description       :clears the array back and sets to original capacity
	public void clear()
	{
		numElements = origcap;
	}
	
	
	//Method Name       :toString
    //Parameters        :None
    //Return value(s)   :String
    //Partners          :None
    //Description       :returns a string for item
	public String toString()
	{
		for(int i = 0; i <= numElements; i++)
		{
			System.out.println(list[i]);
		}	
		return "\n";
	}
	
	
	//Method Name       :sort
    //Parameters        :None
    //Return value(s)   :None
    //Partners          :None
    //Description       :Sorts the employees
	@SuppressWarnings("unchecked")
	public void sort()
	{
		Object insert;
		
		for(int i = 1; i < numElements; i++)
		{
			insert = list[i];
			
			int moveItem = i;
			
			while(moveItem > 0 && ((Comparable<E>) list[i]).compareTo((E) list[i - 1]) == 1)
			{
				list[moveItem] = list[moveItem - 1];
				moveItem--;
			}
			list[moveItem] = insert;
		}
	}
	
	
	
	//Method Name       :enlarge
    //Parameters        :None
    //Return value(s)   :None
    //Partners          :None
    //Description       :enlarge the array
	private void enlarge() throws MaximumCapacityException
	{
		// set up new bigger array
		
		if(numElements <= (DEFCAP - origcap))
		{	
			Object[] listCopy = new Object[list.length + origcap];
			// copy each element of list into new bigger array
			for(int i = 0; i < numElements; i++)
			{
				listCopy[i] = list[i];	
			}
			list = listCopy;
		}
		else if(numElements > (DEFCAP - origcap))
		{
			Object[] listCopy = new Object[DEFCAP];
			for(int i = 0; i < numElements; i++)
			{
				listCopy[i] = list[i];	
			}
			list = listCopy;
		}
		else if(numElements == DEFCAP)
		{
			throw new MaximumCapacityException();
		}
	}
}

























