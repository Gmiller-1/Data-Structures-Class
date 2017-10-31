import java.util.Comparator;

public class MergeSort 
{
    private static void merge(Point[] a, Point[] tempArr, int lo, int m, int hi, Comparator<Point> comparator) 
    {
        // copy to tempArry[]
        for (int k = lo; k <= hi; k++) 
        {
            tempArr[k] = a[k];
        }
        // merge back to a[]
        int i = lo, j = m+1;
        for (int k = lo; k <= hi; k++) 
        {
            if (i > m)
            {
            	a[k] = tempArr[j++];
           	}
            else if (j > hi) 
            {
            	a[k] = tempArr[i++];
           	}
            else if (isLess(comparator, tempArr[j], tempArr[i]))
            {
            	a[k] = tempArr[j++];
           	}
            else
            {
            	a[k] = tempArr[i++];
            }
        }
    }

    // mergesort
    public static void sort(Point[] a, Comparator<Point> comparator) 
    {
        int N = a.length;
        Point[] aux = new Point[N];
        for (int n = 1; n < N; n = n+n) 
        {
            for (int i = 0; i < N-n; i += n+n) 
            {
                int lo = i;
                int m  = i+n-1;
                int hi = Math.min(i+n+n-1, N-1);
                merge(a, aux, lo, m, hi, comparator);
            }
        }
    }

    private static boolean isLess(Comparator<Point> comparator, Point v, Point w) 
    {
        return comparator.compare(v, w) < 0;
    }
}

