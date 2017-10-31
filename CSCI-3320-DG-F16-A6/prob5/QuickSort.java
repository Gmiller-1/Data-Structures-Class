public class QuickSort 
{
	public static void sort(Comparable<Integer>[] a) 
	{
        sort(a, 0, a.length - 1);
    }
	
	private static void sort(Comparable<Integer>[] a, int lo, int hi) { 
        if (hi <= lo)
        {
        	return;
        }
        
        int lt = lo;
        int j = hi;
        Comparable<Integer> v = a[lo];
        int i = lo;
        while (i <= j) 
        {
            int cmp = a[i].compareTo((Integer) v);
            if(cmp < 0) 
            {
            	swap(a, lt++, i++);
            }
            else if (cmp > 0) 
            {
            	swap(a, i, j--);
            }
            else     
            {
            	i++;
            }
        }
 
        sort(a, lo, lt-1);
        sort(a, j+1, hi);
    }
	
	
	private static void swap(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
	}
}
