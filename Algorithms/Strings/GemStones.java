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
        int[] elemOccs = new int[26];
        int loopI,loopJ,numGemElems = 0,currentCharPos;
        
        String rock = null;
        for(loopI=0;loopI<n;++loopI)
        {
            rock = scan.next();
            boolean[] hasAppeared = new boolean[26];
            for(loopJ=0;loopJ<rock.length();++loopJ)
            {
                currentCharPos = rock.charAt(loopJ)-97;
                if(!hasAppeared[currentCharPos])
                {
                    hasAppeared[currentCharPos]=true;
                    ++elemOccs[currentCharPos];
                }
            }
                
        }
        
        for(loopI=0;loopI<26;++loopI)
        {
            if(elemOccs[loopI]==n)
                ++numGemElems;
        }
        
        System.out.println(numGemElems);
    }
}