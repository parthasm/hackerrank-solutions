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
        Scanner scan = new Scanner(System.in) ;
        int numTestCases = scan.nextInt();
        
        String s;
        StringBuilder finalAns = new StringBuilder();
        int loop0,loopI,smallIndex,largeIndex,n; 
        
        for(loop0=0;loop0<numTestCases;++loop0)
        {
            s = scan.next(); n = s.length();  
            smallIndex = -1;
            largeIndex = -1;
            for(loopI=0;loopI<n-1;++loopI)
            {
                if(s.charAt(loopI) < s.charAt(loopI+1))
                    smallIndex = loopI;
            }
            
            if(smallIndex == -1)
            {
                finalAns.append("no answer\n");
                continue;
            }
            
            for(loopI=smallIndex+1; loopI<n;++loopI)
            {
                if(s.charAt(smallIndex)<s.charAt(loopI))
                    largeIndex = loopI;
            }
            
            Character[] ar = new Character[n-(smallIndex+1)];
            
            for(loopI = smallIndex+1; loopI < n; ++loopI)
            {
                if(loopI == largeIndex)
                    ar[loopI-(smallIndex+1)] = s.charAt(smallIndex);
                else
                    ar[loopI-(smallIndex+1)] = s.charAt(loopI);
            }
            Arrays.sort(ar);
            
            for(loopI = 0; loopI < smallIndex; ++loopI)
                finalAns.append(s.charAt(loopI));
            finalAns.append(s.charAt(largeIndex));
            for(char c:ar)
                finalAns.append(c);
            finalAns.append('\n');
        }
        System.out.println(finalAns.toString());
        scan.close();
    }
}