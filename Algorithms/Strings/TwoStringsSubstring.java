import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public static void main(String[] args) 
    {
        /*
        Even if 1 common character is there, substring exists
        */
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        int loop0,loopI,loopJ;
        
        String str1 = null,str2 = null,ans = null;
        for(loop0=0;loop0<numTestCases;++loop0)
        {
            str1 = scan.next();
            str2 = scan.next();
            ans = "NO";
            Set<Character> letterOccs = new HashSet<>();
            for(loopI=0;loopI<str1.length();++loopI)
                letterOccs.add(str1.charAt(loopI));
            
            for(loopI=0;loopI<str2.length();++loopI)
            {
                if(letterOccs.contains(str2.charAt(loopI)))
                {
                    ans = "YES";
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}