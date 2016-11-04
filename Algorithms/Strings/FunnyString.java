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
        int loop0,loopI,loopJ,limit;
        String funCandidate = null;
        boolean isFunny;
        
        for(loop0=0;loop0<numTestCases;++loop0)
        {
            funCandidate = scan.next();
            isFunny = true;
            if(funCandidate.length()%2==0)
                limit = (funCandidate.length()/2) -1;
            else
                limit = funCandidate.length()/2;
            
            for(loopJ=1;loopJ <= limit;++loopJ)
            {
                if(Math.abs(funCandidate.charAt(loopJ) - funCandidate.charAt(loopJ-1)) != 
                Math.abs(funCandidate.charAt(funCandidate.length()-(loopJ+1)) - funCandidate.charAt(funCandidate.length()-loopJ)))
                {
                    isFunny = false;
                    break;
                }
            }
            
            if(!isFunny)
                System.out.println("Not Funny");
            else
                System.out.println("Funny");
        }
    }
}