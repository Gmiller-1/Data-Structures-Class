public class Josephus {

    private int numOfPeople; 	// number of people in Circle
    private int countNum; 		// number used for counting the time potato is passed
    private int passCount = 1;
    private Node head;
    private Node tail;
    CircularLinkedList circleList;

    public Josephus() 
    {
        circleList = new CircularLinkedList();
        numOfPeople = 0;
        countNum = 0;

    }

    public void setNumOfPeople(int x) 
    {
        numOfPeople = x;

    }

    public int getNumOfPeople() 
    {
        return numOfPeople;
    }

    public void setCountNum(int x) 
    {
        countNum = x;
    }

    public int getCountNum() 
    {
        return countNum;
    }

    public void addPeople() 
    {
        for(int i = 1; i < numOfPeople+1; i++) 
        {
            circleList.insert(i);
        }
    }

    public void move() 
    {

        for (int i = 0; i < countNum; i++) 
        {
            tail = head;
            head = head.next;
        }
        
        System.out.println("Pass " + passCount + " eliminated " + head.data + " ");

    }

    public void josephus() 
    {
        tail = null;
        head = circleList.getFirst();
        while (numOfPeople != 1) 
        {
        	move();
            circleList.delete(head.data);
            tail = tail.next;
            head = head.next;
            numOfPeople--;
            display();
            passCount++;
        }

    }

    public void display() 
    {
        System.out.print("Current List: ");
        circleList.displayList();
    }
    
    public void showWinner()
    {
    	circleList.displayList();
    }

}