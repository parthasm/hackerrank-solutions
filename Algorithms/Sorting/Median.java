import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    static void quickSortMain(int[] ar)
    {
        int left = 0,right = ar.length-1,pivotPos;
        while(true)
        {
            pivotPos = partition(ar,left,right);  
            if(pivotPos == ar.length/2)
            {
                System.out.println(ar[pivotPos]);
                break;
            }
                
            else if(pivotPos > ar.length/2)
                right = pivotPos-1;
            
            else
                left = pivotPos+1;
            
        }
        
    }
    
    static int partition(int[] ar, int startIndex,int endIndex)
    {
        if(endIndex-startIndex<1)//1 element or zero element in subarray
            return endIndex;
        
        /*
        Blindly followed the Lomuto Partitioning method
        If element is greater, do nothing
        If element is lesser than pivot, exchange element with 1st larger element before it (if it exists)
        See Lomuto Partitioning gif
        */
        int loopI, pivot = ar[endIndex], replacePos = startIndex; 
        for(loopI=startIndex;loopI<endIndex;++loopI)
        {
            if(ar[loopI]<=pivot)
            {
                if(replacePos!=loopI)
                {
                    ar[replacePos] += ar[loopI];
                    ar[loopI] = ar[replacePos] - ar[loopI];
                    ar[replacePos] = ar[replacePos] - ar[loopI];
                }
                ++replacePos;
            }
        }
        
        if(replacePos!=endIndex)
        {
            ar[replacePos] += ar[endIndex];
            ar[endIndex] = ar[replacePos] - ar[endIndex];
            ar[replacePos] = ar[replacePos] - ar[endIndex];
        }
        
        return replacePos;
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
        
        quickSortMain(ar);
    }    
}
