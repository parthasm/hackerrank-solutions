import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    static void mergeSortDriver(int[] ar)
    {
        mergeSort(ar,0,ar.length-1);
    }
    
    private static void mergeSort(int[] ar,int startIndex,int endIndex)
    {
        if(endIndex-startIndex <= 0)
            return;
        int mid = (startIndex+endIndex)/2;
        //System.out.println(startIndex+" "+mid+" "+endIndex);
        mergeSort(ar,startIndex,mid);
        mergeSort(ar,mid+1,endIndex);
        
        int loopI;
        
        int[] copyAr = new int[endIndex+1-startIndex];
        
        for(loopI=0;loopI<copyAr.length;++loopI)
            copyAr[loopI] = ar[startIndex+loopI];
        
        int copyFirstStart=0,copyFirstEnd,copySecStart,copySecEnd=copyAr.length-1;
        if(copyAr.length%2==0)
            copySecStart = copyAr.length/2;
        else
            copySecStart = (copyAr.length/2)+1;
        copyFirstEnd = copySecStart-1;
        
        loopI = startIndex;
        while(loopI<=endIndex)
        {
            if(copyFirstStart<= copyFirstEnd && copySecStart<=copySecEnd)
            {
                if(copyAr[copyFirstStart]>copyAr[copySecStart])
                {
                    ar[loopI] = copyAr[copySecStart];
                    ++copySecStart;
                }
                else //no equal elements in the array
                {
                    ar[loopI] = copyAr[copyFirstStart];
                    ++copyFirstStart;
                }
            }
            
            else if(copyFirstStart > copyFirstEnd)
            {
                ar[loopI] = copyAr[copySecStart];
                ++copySecStart;
            }
            
            else
            {
                ar[loopI] = copyAr[copyFirstStart];
                ++copyFirstStart;
            }
            ++loopI;
        }
        
    }

    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] ar = new int[n];
        int loopI;
        
        for(loopI=0;loopI<n;++loopI)
            ar[loopI] = scan.nextInt();
        
        scan.close();
        
        mergeSortDriver(ar);
        
        int minDiff = 2147483647;
/*
        for(loopI=0;loopI<ar.length;++loopI)
        {
            System.out.print(ar[loopI]+" ");
        }
  */      
        for(loopI=0;loopI<ar.length-1;++loopI)
        {
            if(ar[loopI+1]-ar[loopI] < minDiff)
                minDiff = ar[loopI+1]-ar[loopI];
        }
    
        for(loopI=0;loopI<ar.length-1;++loopI)
        {
            if(ar[loopI+1]-ar[loopI] == minDiff)
                System.out.print(ar[loopI]+" "+ar[loopI+1]);
        }
    
        
    }
}