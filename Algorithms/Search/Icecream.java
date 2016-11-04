
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
    
    private static boolean binarySearch(int[] ar,int startIndex,int endIndex,int searchNum)
    {
        if(startIndex>endIndex)
            return false;
            
        if(startIndex==endIndex)
        {
            if(ar[startIndex]==searchNum)
                return true;
            else
                return false;
        }
        
        int mid = (startIndex+endIndex)/2;
        if(ar[mid]==searchNum)
            return true;
        else if(ar[mid] > searchNum)
            return binarySearch(ar,startIndex,mid-1,searchNum);
        else
            return binarySearch(ar,mid+1,endIndex,searchNum);
    }
    
    private static void mergeSort(int[] ar,int startIndex,int endIndex)
    {
        if(endIndex-startIndex <= 0)
            return;
        int mid = (startIndex+endIndex)/2;
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
        int numTestCases = scan.nextInt();
        for(int loop0=0;loop0<numTestCases;++loop0)
        {
            int m = scan.nextInt();
            int n = scan.nextInt();
            int[] ar = new int[n];
            int[] copyAr = new int[n];
            int loopI;
            
            for(loopI=0;loopI<n;++loopI)
            {
                ar[loopI] = scan.nextInt();
                copyAr[loopI] = ar[loopI];
            }
            mergeSortDriver(ar);   
            /*
            for(loopI=0;loopI<n;++loopI)
                System.out.print(ar[loopI]+" ");
            System.out.println();
            */
            int icePrice1=-1,icePrice2=-1,index1=-1,index2=-1;
            boolean foundPrices = false;
            
            for(loopI=0;loopI<(n-1);++loopI)
            {
                icePrice1 = ar[loopI];
                icePrice2 = m - icePrice1;
                //System.out.println("Ice-cream prices : "+icePrice1+" "+icePrice2);    
                if(binarySearch(ar,loopI+1,n-1,icePrice2))
                {
                    foundPrices = true;
                    break;
                }
            }
            if(foundPrices)
            {
                for(loopI=0;loopI<n;++loopI)
                {
                    if(copyAr[loopI]==icePrice1)
                    {
                        index1 = loopI;
                        break;
                    }
                    if(copyAr[loopI]==icePrice2)
                    {
                        index1 = loopI;
                        icePrice2 += icePrice1;
                        icePrice1 = icePrice2 - icePrice1;
                        icePrice2 = icePrice2 - icePrice1;
                        break;
                    }
                }
                
                for(int loopJ=loopI+1;loopJ<n;++loopJ)
                {
                    if(copyAr[loopJ]==icePrice2)
                    {
                        index2 = loopJ;
                        break;
                    }
                }
                System.out.println((index1+1)+" "+(index2+1));
            }
            else
                System.out.println("Error");
        }
        
        scan.close();
    }
}