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
        int n = scan.nextInt();
        int[] ar = new int[n];
        int loopI,loopJ,numUnits = 0,floorPrice = 0;
        
        for(loopI = 0; loopI < n; ++loopI)
            ar[loopI] = scan.nextInt();
        scan.close();
        
        Arrays.sort(ar);
        loopI = 0;
        while(loopI < n)
        {
            floorPrice = ar[loopI];
            loopJ = loopI + 1;
            ++numUnits;
            while(loopJ < n && ar[loopJ] <= floorPrice + 4)
                ++loopJ;
            if(loopJ >= n)
                break;
            loopI = loopJ;
        }
        
        System.out.println(numUnits);
    }
}