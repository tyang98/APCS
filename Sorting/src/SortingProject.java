import java.util.Arrays;
/**
 * A sorting project that sorts 5 different sized arrays with three different sorting 
 * algorithms: QuickSort, MergeSort, and Radix Sort
 * @author Aidan Foley, Jeffrey Lantz, Sara Xin, Tony Yang
 * @version 3.19.18
 */
public class SortingProject
{
    private static int[] arr;
    private static int[] sizes = {3125, 6250, 12500, 25000, 50000};

    public static void main(String[] args)
    {
        long[] times = new long[5];
        int index = 0;
        for (int size : sizes)
        {
            arr = new int[size];
            long startTime = System.nanoTime();
            initArr();
            quickSort(0, size - 1);
            //mergeSort(0, size  - 1);
            //radixSort(arr, arr.length);
            long endTime = System.nanoTime();
            times[index] = (endTime - startTime) / 1000000;
            index++;
        }
        for (int i = 0; i < times.length; i++)
        {
            System.out.println("The array of " + sizes[i] + " elements took "
                + times[i] + " milliseconds");
        }
    }

    /**
     * Prints the values in arr
     */
    private static void printValues()
    {
        String ret = "";
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] < 10)
                ret += "0";
            ret += arr[i] + " ";
            if (i % 5 == 4)
                ret += "\n";
        }
        System.out.print(ret);
    }

    /**
     * Returns true if arr is sorted, false if arr is not sorted
     * @return true if arr is sorted, false if arr is not sorted
     */
    private static boolean isSorted()
    {
        boolean isSorted = true;
        for (int i = 0; i < arr.length - 1; i++)
        {
            if (arr[i] > arr[i + 1])
                isSorted = false;
        }
        return isSorted;
    }

    /**
     * Initiates arr with randomly generated integers
     */
    private static void initArr()
    {
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (int)(Math.random() * 101);
        }
    }

    /**
     * Swaps the integers at locations index1 and index2 of arr
     * Precondition: index1 and index2 are less than size
     * @param index1 the first index to swap
     * @param index2 the second index to swap
     */
    public static void swap(int index1, int index2)
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * Sorts arr using the merge sort algorithm
     * @param startIndex the starting index of the unsorted part of arr
     * @param endIndex the ending index of the unsorted part of arr
     */
    public static void mergeSort(int startIndex, int endIndex)
    {
        if (startIndex >= endIndex)
        {
            return;
        }
        int index = (startIndex + endIndex) / 2;
        mergeSort(startIndex, index);
        mergeSort(index + 1, endIndex);
        merge(startIndex, index, index + 1, endIndex);
    }

    /**
     * Merges the two sorted groups of arr
     * @param leftFirst the first index of the left group
     * @param leftLast the last index of the left group
     * @param rightFirst the first index of the right group
     * @param rightLast the last index of the right group
     */
    public static void merge(int leftFirst, int leftLast, int rightFirst, int rightLast)
    {
        int[] temp = new int[arr.length];
        int saveFirst = leftFirst;
        int index = leftFirst;
        while (leftFirst <= leftLast && rightFirst <= rightLast)
        {
            if (arr[leftFirst] < arr[rightFirst])
            {
                temp[index] = arr[leftFirst];
                leftFirst++;
            }
            else
            {
                temp[index] = arr[rightFirst];
                rightFirst++;
            }
            index++;
        }

        for (int i = leftFirst; i <= leftLast; i++)
        {
            temp[index] = arr[i];
            index++;
        }			

        for (int i = rightFirst; i < rightLast; i++)
        {
            temp[index] = arr[i];
            index++;
        }

        for (int i = saveFirst; i < index; i++)
        {
            arr[i] = temp[i];
        }
    }

    /**
     * Sorts arr using the quick sort algorithm
     * @param from the starting index of the unsorted part of arr
     * @param to the ending index of the unsorted part of arr
     */
    public static void quickSort(int from, int to)
    {
        if (from < to)
        {
            int p = split(from, to);
            quickSort(from, p - 1);
            quickSort(p + 1, to);
        }
        else
        {
            return;
        }
    }

    /**
     * Splits the unsorted part of arr 
     * @param from the starting index of the unsorted part of arr
     * @param to the ending index of the unsorted part of arr
     * @return the index where the pivot point should be in arr
     */
    public static int split(int from, int to)
    {
        int pivot = arr[from];
        int first = from;
        int last = to;
        while (first < last)
        {
            first++;
            while (first < arr.length && arr[first] <= pivot)
            {
                first++;
            }
            while (arr[last] > pivot)
            {
                last--;
            }
            if (first <  last)
            {
                swap(first, last);
            }
        }
        swap(from, last);
        return last;
    }

    /**
     * Sorts arr using the radix sort algorithm
     * @param arr the array to be sorted
     * @param n the number of elements in arr 
     */
    public static void radixSort(int[] arr, int n)
    {
    	int expo = 1;
        int max = getMax(arr, n);
        while (max / expo > 0)
        {
        	countSort(arr, n, expo);
        	expo *= 10;
        }
    }
    
    /**
     * Returns the maximum value within arr
     * @param arr the array that the maximum value should be found in
     * @param n the number of elements in arr
     * @return the maximum value within arr
     */
    public static int getMax(int[] arr, int n)
    {
        int max = arr[0];
        for (int i = 1; i < n; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
            }
        }
        return max;
    }
    
    /**
     * Sorts arr using the countSort algorithm
     * Credit to geeksforgeeks.org/radix-sort/
     * @param arr the array to be sorted 
     * @param n the size of the output array
     * @param expo the exponent that determines the count of the specified element
     */
    public static void countSort(int arr[], int n, int expo)
    {
        int[] output = new int[n];
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (int i = 0; i < n; i++)
            count[(arr[i] / expo) %10 ]++;
        
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--)
        {
            output[count[(arr[i] / expo) % 10 ] - 1] = arr[i];
            count[(arr[i] / expo) % 10 ]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];    	
    }
}

