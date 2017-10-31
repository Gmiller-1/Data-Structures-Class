public class CircularLinkedList {

    private Node first;
    private Node current;
    private int count; 						// number of elements in the list
    public CircularLinkedList getCurrent;

    public CircularLinkedList() 
    {
        first = null;
        current = null;
        count = 0;
    }

    public boolean isEmpty() 
    {
        return first == null;
    }

    public void step() 
    {
        current = current.next;
    }

    public Node getCurrent() 
    {
        return current;
    }

    public Node getFirst() 
    {
        return first;
    }

    public void insert(int x) 
    {
        Node newNode = new Node(x);

        if (isEmpty()) 
        {
            first = newNode;
            current = first;
        } 
        else 
        {
            current.next = newNode;
        }

        newNode.next = first;
        step();
        count++;
    }

    public boolean search(int x) 
    {
        Node search = first;
        int y = 0;

        while (search.data != x && y < count) {
            search = search.next;
            y++;
        }

        if (search.data == x) {
            System.out.println("Found the value: " + search.data);
            return true;
        } 
        else 
        {
            System.out.println("Value not found in list");
            return false;
        }

    }

    public void delete(int x) 
    {
        Node prev = first;
        Node current = first.next;

        while (current.data != x) 
        {
            prev = current;
            current = current.next;
        }
        if (count == 1) {
            first = null;
            count--;
        } 
        else if (current == first) {
            prev.next = current.next;
            first = current.next;
            count--;
        } 
        else {
            prev.next = current.next;
            count--;
        }

    }

    public void displayList() {
        int x = 0;
        Node toPrint = first;

        while (x < count) {
            toPrint.displayNode();
            toPrint = toPrint.next;
            System.out.print(" ");
            x++;
        }
        System.out.println(" ");

    }

}