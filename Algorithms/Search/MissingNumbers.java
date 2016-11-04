import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int loopI,m,n,minInB = 10000;
        n = scan.nextInt();
        int[] A = new int[n];
        for(loopI = 0; loopI < n; ++loopI)
            A[loopI] = scan.nextInt();
        
        m = scan.nextInt();
        int[] B = new int[m];
        for(loopI = 0; loopI < m; ++loopI)
        {
            B[loopI] = scan.nextInt();
            if(minInB > B[loopI])
                minInB = B[loopI];
        }
        scan.close();
        
        int[] freqAr = new int[101];
        for(loopI = 0; loopI < m; ++loopI)
            ++freqAr[B[loopI]-minInB];
           
        for(loopI = 0; loopI < n; ++loopI)
            --freqAr[A[loopI]-minInB];
        
        for(loopI = 0; loopI < 101; ++loopI)
        {
            if(freqAr[loopI]>0)
                System.out.print((loopI+minInB)+" ");
        }    
    }
}