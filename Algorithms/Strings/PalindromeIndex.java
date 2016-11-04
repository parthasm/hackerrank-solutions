import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    /*
    I'll try explaining my way.
-
There are two kinds of strings you will get in this problem.
1) One that is already palindrome.
2) One that is not palindrome, and will require you to remove one and only one character to make it palindrome.
We'll use the same method we use to check if a string is palindrome or not 
(i.e., check the first with the last character, check 2nd with 2nd last character, and so on). 
Except here, we note where we get an inequal condition.
And after that we check if removing either of the two makes palindrome or not.
    */
    private static boolean isPalin(String candString)
    {
        for(int loopI=0;loopI<candString.length()/2;++loopI)
        {
            if(candString.charAt(loopI) != candString.charAt(candString.length()-(1+loopI)))
                return false;
        }
        return true;
    }
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        int loop0,loopI,nonMatchIndex1,nonMatchIndex2;
        
        String palinTrans = null;
        boolean canBePalin;
        for(loop0=0;loop0<numTestCases;++loop0)
        {
            palinTrans = scan.next();
            canBePalin = false;
            nonMatchIndex1=-1;
            nonMatchIndex2=-1;
            if(isPalin(palinTrans))
            {
                System.out.println(-1);
                canBePalin = true;
                continue;
            }
            
            for(loopI=0;loopI<palinTrans.length()/2;++loopI)
            {
                if(palinTrans.charAt(loopI)==palinTrans.charAt(palinTrans.length()-(1+loopI)))
                    continue;
                
                nonMatchIndex1 = loopI;
                nonMatchIndex2 = palinTrans.length()-(1+loopI);
                StringBuilder st = new StringBuilder(palinTrans.substring(0,nonMatchIndex1));
                st.append(palinTrans.substring(nonMatchIndex1+1));
                if(isPalin(st.toString()))
                {
                    System.out.println(nonMatchIndex1);
                    canBePalin = true;
                    break;
                }
                else
                {
                    st = new StringBuilder(palinTrans.substring(0,nonMatchIndex2));
                    st.append(palinTrans.substring(nonMatchIndex2+1));
                    if(isPalin(st.toString()))
                    {
                        System.out.println(nonMatchIndex2);
                        canBePalin = true;
                        break;
                    }
                }
            }
            
            if(!canBePalin)
                System.out.println(-1);
        }
    }
}
