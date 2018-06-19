import java.util.Arrays;
public class Sorts {

	private static int[] arr;
	private static int[] sizes = {25, 100, 500, 1000, 5000};

	public static void main(String[] args)
	{
		long[] times = new long[5];
		int index = 0;
		for (int size : sizes)
		{
			arr = new int[size];
			long startTime = System.nanoTime();
			initArr();
			printValues();
			System.out.println(isSorted());
			//quickSort(0, size - 1);
			//mergeSort(0, i  - 1);
			//radixSort(arr, arr.length);
			printValues();
			System.out.println(isSorted() + "\n");
			long endTime = System.nanoTime();
			times[index] = (endTime - startTime) / 1000000;
			index++;
		}
		for (int i = 0; i < times.length; i++)
		{
			System.out.println("The array of " + (i + 1) * 5 + " elements took "
					+ times[i] + " milliseconds");
		}
	}
	
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
	
	private static void initArr()
	{
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = (int)(Math.random() * 101);
		}
	}

	 public static void swap(int index1, int index2)
    // Swaps the integers at locations index1 and index2 of array values
    // Precondition:  index1 and index2 are less than size
    {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
	 
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

    public static int getMax(int[] arr, int n)
    {
    	int max = arr[0];
    	for (int i = 1; i < arr.length; i++)
    	{
    		if (arr[i] > max)
    		{
    			max = arr[i];
    		}
    	}
    	return max;
    }
    
    public static void countSort(int arr[], int n, int expo)
    {
    	int[] output = new int[n];
    	int count[] = new int[10];
    	Arrays.fill(count,0);
    	 
        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++)
            count[(arr[i] / expo) %10 ]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
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
    
    public static void radixSort(int[] arr, int n)
    {
    	int max = getMax(arr, n);
    	for (int expo = 1; max / expo > 0; expo *= 10)
    	{
    		countSort(arr, n, expo);
    	}
    }
}


