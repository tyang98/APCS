/**
 * Creates a random permutations of integers from 1 through 10
 * @author Tony Yang and Aidan Foley
 * @version 1.9.18
 */
public class PermutationArray
{
    public static void main(String[] args)
    {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = (int) (Math.random() * 10 + 1);
            for (int j = 0; j < i; j++)
            {
                if (arr[i] == arr[j])
                {
                    i--;
                }
            }
        }
        
        for(int w = 0; w < arr.length; w++)
        {
            for (int b = w + 1; b < arr.length; b++)
            {
                if(arr[w] < arr[b])
                {
                    int temp = arr[w];
                    arr[w] = arr[b];
                    arr[b] = temp;
                }
            }
        }
        
        for(int num : arr)
        {
            System.out.print(num + " ");
        }
        System.out.println();
       }
}

