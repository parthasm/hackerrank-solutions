import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        in.close();
        
        int loopI,numChars = 0;
        char c1='a',c2='a',c3='a';
        for(loopI=0;loopI<S.length();loopI+=3)
        {
            c1 = S.charAt(loopI);   c2 = S.charAt(loopI+1); c3 = S.charAt(loopI+2);
            if(c1!='S')
                ++numChars;
            if(c2!='O')
                ++numChars;
            if(c3!='S')
                ++numChars;
        }
        
        System.out.println(numChars);
    }
}
