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
        int loop0,numOpers,loopI,lengthLoveLetter;
        String loveLetter = null;
        
        for(loop0=0;loop0<numTestCases;++loop0)
        {
            loveLetter = scan.next();
            lengthLoveLetter = loveLetter.length();
            numOpers = 0;
            
            for(loopI=0;loopI<lengthLoveLetter/2;++loopI)
                numOpers+= Math.abs(loveLetter.charAt(loopI)-loveLetter.charAt(lengthLoveLetter-(loopI+1)));
            System.out.println(numOpers);    
        }
    }
}