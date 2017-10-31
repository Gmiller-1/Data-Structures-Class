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


public class ListNode<E extends Comparable<E>>
{
	private E data;
	private ListNode<E> nextnode;
	
	
	public ListNode(E d)
	{
		data = d;
		nextnode = null;
	}
	
	public ListNode(E d, ListNode<E> node)
	{
		data = d;
		nextnode = node;
	}
	
	//Method Name       :setData
    //Parameters        :d
    //Return value(s)   :None
    //Partners          :None
    //Description       :set node data
	public void setData(E d)
	{
		this.data = d;
	}
	
	
	//Method Name       :getData
    //Parameters        :None
    //Return value(s)   :E
    //Partners          :None
    //Description       :get node data
	public E getData()
	{
		return this.data;
		
	}
	
	//Method Name       :setNext
    //Parameters        :next
    //Return value(s)   :None
    //Partners          :None
    //Description       :set next node
	public void setNext(ListNode<E> next)
	{
		this.nextnode = next;
	}
	
	
	//Method Name       :getNext
    //Parameters        :None
    //Return value(s)   :ListNode<E>
    //Partners          :None
    //Description       :gets next node
	public ListNode<E> getNext()
	{
		return this.nextnode;
		
	}
}
