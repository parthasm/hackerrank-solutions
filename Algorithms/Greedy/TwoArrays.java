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
            int n = scan.nextInt();
            int k = scan.nextInt();
            Integer[] A = new Integer[n];
            int[] B = new int[n];
            
            int loopI;
            
            for(loopI = 0; loopI < n; ++loopI)
                A[loopI] = scan.nextInt();
            for(loopI = 0; loopI < n; ++loopI)
                B[loopI] = scan.nextInt();
            
            Arrays.sort(A, Collections.reverseOrder());
            Arrays.sort(B);
            
            boolean yes = true;
            
            for(loopI = 0; loopI < n; ++loopI)
            {
                if(A[loopI]+B[loopI] < k)
                {
                    yes = false;
                    break;
                }    
            }
            
            if(!yes)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
        scan.close();
    }
}