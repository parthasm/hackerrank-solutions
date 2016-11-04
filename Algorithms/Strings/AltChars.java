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
        int loop0,loopI,numDel,loopJ;
        
        String abSeq = null;
        for(loop0=0;loop0<numTestCases;++loop0)
        {
            abSeq = scan.next();
            loopI=0;
            numDel=0;
            while(loopI<abSeq.length())
            {
                for(loopJ=loopI+1;loopJ<abSeq.length();++loopJ)
                {
                    if(abSeq.charAt(loopI)!=abSeq.charAt(loopJ))
                        break;
                    ++numDel;
                }
                loopI=loopJ;
            }
            System.out.println(numDel);
        }
    }
}
