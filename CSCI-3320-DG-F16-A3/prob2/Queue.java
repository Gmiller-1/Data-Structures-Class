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

public class Queue<E extends Comparable<E>>
{
	private LinkedList<E> list;
	
	public Queue()
	{
		list = new LinkedList<E>();
	}
	
	public Queue(String name)
	{
		list = new LinkedList<E>(name);
	}
	
	
	//Method Name       :enqueue
    //Parameters        :item
    //Return value(s)   :None
    //Partners          :None
    //Description       :adds employee to queue
	public void enqueue(E item)
	{
		list.insertAtBack(item);
	}
	
	
	//Method Name       :dequeue
    //Parameters        :item
    //Return value(s)   :E
    //Partners          :None
    //Description       :removes employee from queue
	public E dequeue()
	{
		E data = list.getItem(0);
		list.removeFromFront();
		return data;
	}
	
	
	//Method Name       :lengthIs
    //Parameters        :None
    //Return value(s)   :int
    //Partners          :None
    //Description       :returns length of queue
	public int lengthIs()
	{
		int length = list.lengthIs();
		return length;
	}
	
	
	//Method Name       :peek
    //Parameters        :None
    //Return value(s)   :E
    //Partners          :None
    //Description       :looks at first item in queue
	public E peek()
	{
		return list.getItem(0);
	}
	
	
	//Method Name       :toString
    //Parameters        :None
    //Return value(s)   :String
    //Partners          :None
    //Description       :return string of all queue members
	public String toString()
	{
		return list.toString();
	}
	
	
	//Method Name       :isEmpty
    //Parameters        :None
    //Return value(s)   :Boolean
    //Partners          :None
    //Description       :checks if queue is empty
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
	
	public void clear()
	{
		list.clear();
	}
	
}
