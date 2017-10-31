
public class HeapSort<Anytype extends Comparable<? super Anytype>>
{

     
    private static int leftChild( int i )
    {
        return 2 * i + 1;
    }
    
    private static <AnyType extends Comparable<? super AnyType>> void percDown( AnyType [ ] a, int i, int n )
    {
        int child;
        AnyType tmp;

        for( tmp = a[ i ]; leftChild( i ) < n; i = child )
        {
            child = leftChild( i );
            
            if( child != n - 1 && a[ child ].compareTo( a[ child + 1 ] ) < 0)
                child++;
            if(tmp == null)
            {
            	break;
            }
            if( tmp.compareTo( a[ child ] ) < 0)
                a[ i ] = a[ child ];
            else
                break;
        }
        a[ i ] = tmp;
    }
    
    
    
    @SuppressWarnings("unchecked")
	public static <AnyType extends Comparable<? super AnyType>> void heapsort( AnyType [ ] arr, AnyType low, AnyType high )
    {  
    	Integer[] a = new Integer[arr.length];
    	int count = 0;
    	
    	for(int i = 0; i < a.length; i++)
    	{
    		
    		if(   (arr[i].compareTo( low) == 1 && arr[i].compareTo( high) == -1) || (arr[i].compareTo(high) == 0 || arr[i].compareTo(low) == 0))
    		{
    			a[count] = (Integer) arr[i];
    			count++;
    		}
    	}
    	
    	// buildHeap 
        for( int i = count / 2 - 1; i >= 0; i-- )  
        {
            percDown( a, i, count );
        }
        
        
        // deleteMax 
        for( int i = count - 1; i > 0; i-- )
        {
            swap( a, 0, i );                
            percDown( a, 0, i );
        }
        
        
        int newcount = 0;
        for(int j = 0; j < arr.length; j++)
        {
        	
        	if(   (arr[j].compareTo( low) == 1 && arr[j].compareTo( high) == -1) || (arr[j].compareTo(high) == 0 || arr[j].compareTo(low) == 0))
    		{
    			arr[j] =  (AnyType) a[newcount];
    			newcount++;
    		}
    		
        }
    }
    
    public static <AnyType extends Comparable<? super AnyType>> void swap(AnyType a[], int i, int j)
    {
    	AnyType temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
   
    
}










