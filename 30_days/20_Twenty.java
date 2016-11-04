import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++)
            a[a_i] = in.nextInt();
        
        int totalNumSwaps = 0,loopI,loopJ,numSwaps;
        
        for(loopI=0;loopI<n;++loopI)
        {
            numSwaps = 0;
            for(loopJ=0;loopJ<n-(1+loopI);++loopJ)
            {
                if(a[loopJ] > a[loopJ+1])
                {
                    a[loopJ] = a[loopJ+1] + a[loopJ];
                    a[loopJ+1] = a[loopJ] - a[loopJ+1];
                    a[loopJ] = a[loopJ] - a[loopJ+1];
                    ++numSwaps;
                }
            }
            if(numSwaps==0)
                break;
            totalNumSwaps += numSwaps;
        }
        
        System.out.println("Array is sorted in "+totalNumSwaps+" swaps.");
        System.out.println("First Element: "+a[0]);
        System.out.println("Last Element: "+a[n-1]);
    }
}
