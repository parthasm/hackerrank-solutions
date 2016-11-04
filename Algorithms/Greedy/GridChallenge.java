import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
The swapping operation described is the operation in Bubble sort
If we are allowed to perform that on elements in a row any number of times,
a row would get sorted
Thus we would be able to sort all rows
After that, by the problem condition, we would check if the columns are also sorted 
If yes, we print yes, else we print no
*/

public class Solution 
{
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for(int loop0 = 0; loop0 < numTestCases; ++loop0)
        {
            int n = scan.nextInt();
            String[] ar = new String[n];
            int loopI,loopJ;
            
            for(loopI = 0; loopI < n; ++loopI)
            {
                String s = scan.next();
                char[] charAr = s.toCharArray();
                Arrays.sort(charAr);
                ar[loopI] = new String(charAr);
            }
            
            boolean yes = true;
            
            for(loopI = 0; loopI < n; ++loopI)
            {
                for(loopJ = 0; loopJ < n-1; ++loopJ)
                {
                    if(ar[loopJ].charAt(loopI) > ar[loopJ+1].charAt(loopI))
                    {
                        yes = false;
                        break;
                    }
                }
                if(!yes)
                    break;
            }
            
            if(yes)
                System.out.println("YES");
            else
                System.out.println("NO");
            
        }
        scan.close();
    }
}