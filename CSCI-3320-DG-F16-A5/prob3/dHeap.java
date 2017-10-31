
public class dHeap<Anytype extends Comparable<? super Anytype>>
{ 

    private static final int DEFAULT_CAPACITY = 10;
    
    public int d;
    private int currentSize; 
    // Number of elements in heap
    private Anytype [ ] array; // The heap array
    
	 /**
     * Construct the binary heap.
     */
    public dHeap( )
    {
        this( DEFAULT_CAPACITY );
    }

    /**
     * Construct the binary heap.
     * @param capacity the capacity of the binary heap.
     */
    public dHeap( int capacity )
    {
        currentSize = 0;
        array = (Anytype[]) new Comparable[ capacity + 1 ];
    }
    
    /**
     * Construct the binary heap given an array of items.
     */
    public dHeap( Anytype [ ] items, int d )
    { 
    		this.d = d;
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
        for( array[ 0 ] = x; x.compareTo( array[ hole / d ] ) < 0; hole /= d )
            array[ hole ] = array[ hole / d ];
        array[ hole ] = x;
    }
    
    
    
    
    
    private void enlargeArray( int newSize)
    {
    	this.d = d;
        Anytype [] old = array;
        array = (Anytype []) new Comparable[ newSize ];
        for( int i = 0; i < old.length; i++ )
        	array[ i ] = old[ i ];        
    }
    
    
    public void setD(int d)
    {
    	this.d = d;
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
        for( int i = currentSize / d; i > 0; i-- )
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

        for( ; hole * d <= currentSize; hole = child )
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
