//----------------------------------------------------------------------------
// Sorts.java                  by Dale/Joyce/Weems                  Chapter 10
//
// Test harness used to run sorting algorithms
//
// Edited by F. Deppe 01-18-11
//----------------------------------------------------------------------------

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Sorts
{
    public static final int SIZE = 50;          // Size of array to be sorted
    private static int[] values = new int[SIZE];  // Values to be sorted
    
    private static void initValues()
    // Initializes the values array with random integers from 0 to 99
    {
        Random rand = new Random(560);
        for (int index = 0; index < SIZE; index++)
            values[index] = Math.abs(rand.nextInt()) % 100;
    }
    
    public static boolean isSorted()
    // Determine whether the array values are sorted
    {
        boolean sorted = true;
        for (int i = 0; i < values.length - 1; i++)
            if (values[i] > values[i + 1])
                sorted = false;
        return sorted;   
    }
    
    public static void swap(int index1, int index2)
    // Swaps the integers at locations index1 and index2 of array values
    // Precondition:  index1 and index2 are less than size
    {
        int temp = values[index1];
        values[index1] = values[index2];
        values[index2] = temp;
    }
    
    public static int minIndex(int startIndex, int endIndex)
    {
    	int temp = startIndex;
    	endIndex= values.length - 1;
    	for (int i = startIndex + 1; i < values.length; i++)
    	{
    		if (values[i] < values[temp])
    		{
    			temp = i;
    		}
    	}
    	return temp;
    }
    
    public static void selectionSort()
    {
    	int current = 0;
    	while (current < values.length)
    	{
    	    int index = minIndex(current, values.length - 1);
    		swap(current, index);
    		current++;
    	}
    }
    
    public static void insertionSort()
    {
    	int count = 1;
    	while (count < values.length)
    	{
    		insertItem(0, count);
    		count++;
    	}
    }
   
    public static void insertItem(int startIndex, int endIndex)
    {
    	boolean finished = false; 
    	int current = endIndex;
    	boolean moreToSearch = true;
    	while (moreToSearch && !finished)
    	{
    		if (values[current] < values[current - 1])
    		{
    			swap(current, current - 1);
    			current--;
    			moreToSearch = (current != startIndex);
    		}
    		else
    		{
    			finished = true;
    		}
    	}
    	
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
    	int[] temp = new int[values.length];
    	int saveFirst = leftFirst;
    	int index = leftFirst;
    	while (leftFirst <= leftLast && rightFirst <= rightLast)
    	{
    		if (values[leftFirst] < values[rightFirst])
    		{
    			temp[index] = values[leftFirst];
    			leftFirst++;
    		}
    		else
    		{
    			temp[index] = values[rightFirst];
    			rightFirst++;
    		}
    		index++;
    	}
    	
    	for (int i = leftFirst; i <= leftLast; i++)
    	{
    		temp[index] = values[i];
    		index++;
    	}			
    	
    	for (int i = rightFirst; i < rightLast; i++)
    	{
    		temp[index] = values[i];
    		index++;
    	}
    	
    	for (int i = saveFirst; i < index; i++)
    	{
    		values[i] = temp[i];
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
    	int pivot = values[from];
    	int first = from;
    	int last = to;
    	while (first < last)
    	{
    		first++;
    		while (first < values.length && values[first] <= pivot)
    		{
    			first++;
    		}
    		while (values[last] > pivot)
    		{
    			last--;
    		}
    		if (first < last)
    		{
    			swap(first, last);
    		}
    	}
    	swap(from, last);
    	return last;
    }
    
    public static void bubbleSort () {
    	int current = 0;
        while (current < values.length)
        {
            bubbleUp(0, current);
            current++;
        }
    }
    
    public static void bubbleUp(int startIndex, int endIndex) {
        for (int i = endIndex; i >= startIndex + 1; i--) {
            if (values[i] < values[i - 1])
            {
                swap(i, i - 1);
            }
        }
    }
    
    public static void printValues()
    // Prints all the values integers
    {
        int value;
        DecimalFormat fmt = new DecimalFormat("00");
        System.out.println("the values array is:");
        for (int index = 0; index < SIZE; index++)
        {
            value = values[index];
            if (((index + 1) % 10) == 0)
                System.out.println(fmt.format(value));
            else
                System.out.print(fmt.format(value) + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) throws IOException
    // Tests the other methods of the Sorts class
    {
        initValues();
        bubbleSort();
        printValues();
        System.out.println("values is sorted: " + isSorted());
        System.out.println();

        swap(0, 1);
        bubbleSort();
        printValues();
        System.out.println("values is sorted: " + isSorted());
        System.out.println();
    }   
}
