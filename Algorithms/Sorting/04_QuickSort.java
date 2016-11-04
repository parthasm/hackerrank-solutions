import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    static void countDiffQuickInsertion(int[] ar)
    {
        int[] arCopy = new int[ar.length];
        for(int loopI=0;loopI<ar.length;++loopI)
            arCopy[loopI] = ar[loopI];
        int numSwapQ = quickSort(ar,0,ar.length-1);
        int numSwapI = insertionSort(arCopy);
        
        System.out.println(numSwapI - numSwapQ);
    }
    
    static int insertionSort(int[] ar)
    {       
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
        int loopI,loopJ,n = ar.length,V,numShifts=0;
        for(loopI=1;loopI<n;++loopI)   
        {
            V = ar[loopI];
            loopJ = loopI-1;
            while(loopJ>-1 && ar[loopJ]>V)
            {
                ar[loopJ+1]=ar[loopJ];
                --loopJ;
                ++numShifts;
            }
            ar[loopJ+1] = V;
        }
        return numShifts;   
    }      
    
    static int quickSort(int[] ar, int startIndex,int endIndex)
    {
        if(endIndex-startIndex<1)//1 element or zero element in subarray
            return 0;
        
        /*
        Blindly followed the Lomuto Partitioning method
        If element is greater, do nothing
        If element is lesser than pivot, exchange element with 1st larger element before it (if it exists)
        See Lomuto Partitioning gif
        */
        int loopI, pivot = ar[endIndex], replacePos = startIndex,numSwaps=0; 
        for(loopI=startIndex;loopI<endIndex;++loopI)
        {
            if(ar[loopI]<pivot)
            {
                if(replacePos!=loopI)
                {
                    ar[replacePos] += ar[loopI];
                    ar[loopI] = ar[replacePos] - ar[loopI];
                    ar[replacePos] = ar[replacePos] - ar[loopI];
                }
                ++replacePos;
                ++numSwaps;
            }
        }
        
        if(replacePos!=endIndex)
        {
            ar[replacePos] += ar[endIndex];
            ar[endIndex] = ar[replacePos] - ar[endIndex];
            ar[replacePos] = ar[replacePos] - ar[endIndex];
        }
        ++numSwaps;
        numSwaps+=quickSort(ar,startIndex,replacePos-1);
        numSwaps+=quickSort(ar,replacePos+1,endIndex);
        return numSwaps;
    }
    
    static void printArray(int[] ar) 
    {
        for(int n: ar)
            System.out.print(n+" ");
           System.out.println("");
    }
       
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++)
          ar[i]=in.nextInt(); 
        
        countDiffQuickInsertion(ar);
    }    
}
