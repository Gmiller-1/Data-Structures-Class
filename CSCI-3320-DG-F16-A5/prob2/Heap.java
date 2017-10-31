
public class Heap<Anytype extends Comparable<? super Anytype>>
{
	
    private static final int DEFAULT_CAPACITY = 10;
    

    private int currentSize; 
    // Number of elements in heap
    private Anytype [ ] array; // The heap array
    
	 /**
     * Construct the binary heap.
     */
    public Heap( )
    {
        this( DEFAULT_CAPACITY );
    }

    /**
     * Construct the binary heap.
     * @param capacity the capacity of the binary heap.
     */
    public Heap( int capacity )
    {
        currentSize = 0;
        array = (Anytype[]) new Comparable[ capacity + 1 ];
    }
    
    /**
     * Construct the binary heap given an array of items.
     */
    public Heap( Anytype [ ] items )
    {
            currentSize = items.length;
            array = (Anytype[]) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

            //int i = 1;
            //for( Integer item : items )
               // array[ i++ ] = item;
            
            for(int i = 1; i <= currentSize; i++)
            {
            	array[i] = items[i - 1];
            }
            buildHeap( );
    }



    
    
    
    
    public void insert( Anytype x )
    {
        if( currentSize == array.length - 1 )
            enlargeArray( array.length * 2 + 1 );

            // Percolate up
        int hole = ++currentSize;
        for( array[ 0 ] = x; x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 )
            array[ hole ] = array[ hole / 2 ];
        array[ hole ] = x;
    }
    
    
    
    
    private void insertTemp(Anytype x)
    {
    	array[0] = x;
    }


    
    
    
    private void enlargeArray( int newSize )
    {
            Anytype [] old = array;
            array = (Anytype []) new Comparable[ newSize ];
            for( int i = 0; i < old.length; i++ )
                array[ i ] = old[ i ];        
    }
    
    
    
    
    
    public void remove(Anytype x)
    {
    	
    	int index = findItem(x);
    	if(index == 0)
    	{
    		System.out.println("Key not found in heap");
    	}
    	Integer n = (int) Double.NEGATIVE_INFINITY;
    	decreaseKey(index,(Anytype) n);
    	
    	int hole = currentSize;
        buildHeap();
        deleteMin();
    	
    }
    
    
    
    
    private void decreaseKey(int pos, Anytype n)
    {
    	array[pos] = n;
    }
    
    
    
    
    public void changeValue(Anytype x, Anytype xnew)
    {
    	int index = findItem(x);
    	
    	array[index] = xnew;
    	
    	buildHeap();
    }
    
    
    
    
    private int findItem(Anytype x)
    {
    	for(int i = 1; i < array.length; i++)
    	{
    		if(array[i].compareTo(x) == 0)
    		{
    			return i;
    		}
    	}
		return 0;
    }


    
    
    public Anytype findMin( )
    {
        if( isEmpty( ) )
            return null;
        return array[ 1 ];
    }



    
    
    public Anytype deleteMin( )
    {
        if( isEmpty( ) )
            return null;

        Anytype minItem = findMin( );
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );

        return minItem;
    }



    
    
    public void buildHeap( )
    {
        for( int i = currentSize / 2; i > 0; i-- )
            percolateDown( i );
    }


    

    
    public boolean isEmpty( )
    {
        return currentSize == 0;
    }

   
    
    
    
    public void makeEmpty( )
    {
        currentSize = 0;
    }


    

    
    private void percolateDown( int hole )
    {
        int child;
        Anytype tmp = array[ hole ];

        for( ; hole * 2 <= currentSize; hole = child )
        {
            child = hole * 2;
            if( child != currentSize && array[ child + 1 ].compareTo( array[ child ] ) < 0 )
                child++;
            if( array[ child ].compareTo( tmp ) < 0 )
                array[ hole ] = array[ child ];
            else
                break;
        }
        array[ hole ] = tmp;
    }
    
    
    
    
    
    
    public void printHeap()
    {
    	String toPrint = "";
    	
    	for(int i = 1; i <= currentSize; i++)
    	{
    		toPrint += array[i].toString() + " ";
    	}
    	
    	System.out.println(toPrint);
    }
}
