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
        int numTestCases = scan.nextInt();
        for(int loop0=0;loop0<numTestCases;++loop0)
        {
            boolean indexExists = false;
            int loopI,redSum = 0,incSum = 0;
            int n = scan.nextInt();
            int[] ar = new int[n];
            for(loopI=0;loopI<n;++loopI)
            {
                ar[loopI] = scan.nextInt();
                redSum += ar[loopI];
            }
            
            redSum -= ar[0];
            if(redSum == incSum)            
                indexExists = true;
            for(loopI=1;loopI<n && redSum > incSum;++loopI)
            {
                incSum += ar[loopI-1];
                redSum -= ar[loopI];
                if(redSum==incSum)
                {
                    indexExists = true;
                    break;
                }
            }
            
            if(indexExists)
                System.out.println("YES");
            else
                System.out.println("NO");
            
        }
        scan.close();
    }
}