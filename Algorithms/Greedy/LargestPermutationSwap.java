import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Starting from the beginning, find the number which should be in that position,
This will always be the largest number possible
For example,
if array
4 2 5 3 1
NUmber in 1st position should be 5,
so we do a nested loop to find 5 in the rest of the array, swap it with 4 when found & hence proceed
to the next element 
*/

public class Solution 
{
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] ar = new int[n];
        int loopI;
        
        for(loopI =0; loopI < n; ++loopI)
            ar[loopI] = scan.nextInt();
        scan.close();
        
        int loopJ,reqNum, numSwaps = 0;
        
        for(loopI = 0; loopI < n-1; ++loopI)
        {
            reqNum = n - loopI;
            if(numSwaps < k)
            {
                if(ar[loopI]!=reqNum)
                {
                    ++numSwaps;
                    for(loopJ = loopI+1; loopJ<n; ++loopJ)
                    {
                        if(ar[loopJ]==reqNum)
                        {
                            ar[loopJ] = ar[loopI];
                            ar[loopI] = reqNum;
                            break;
                        }
                    }
                    
                }
            }
            else
                break;
            
        }
        
        for(loopI =0; loopI <n; ++loopI)
            System.out.print(ar[loopI] + " ");
    }
}