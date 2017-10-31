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

This is an exception
*/ 
package exceptions;

public class InvalidEmployeeNumberException extends Exception
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public InvalidEmployeeNumberException(int num)
   {
      super(num + " is not a valid EmployeeNumber\n");
   }
}