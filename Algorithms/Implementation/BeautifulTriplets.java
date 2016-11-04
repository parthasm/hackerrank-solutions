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
        int d = scan.nextInt();
        int loopI;
        int[] ar = new int[n];
        for(loopI = 0; loopI < n; ++loopI)
            ar[loopI] = scan.nextInt();
        scan.close();
        
        int loopJ,numsFound=-1,numsTriplet=0;
        
        for(loopI = 0 ; loopI < n-2; ++loopI)
        {
            loopJ = loopI + 1;
            numsFound = 0;
            while(loopJ < n && ar[loopJ] <= ar[loopI]+(2*d))
            {
                if((ar[loopJ] == ar[loopI]+d) || (ar[loopJ] == ar[loopI]+(2*d)))
                    ++numsFound;
                ++loopJ;
            }
            
            if(numsFound == 2)
                ++numsTriplet;
        }
        
        System.out.println(numsTriplet);
    }
}
