import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public static void main(String[] args) 
    {
        //Logic: half of the sum of the absolute values in map is the minimum change required
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        int loop0,loopI,val,loopJ,anagLength,minNumChanges;
        String anag = null,anag1,anag2;
        
        for(loop0=0;loop0<numTestCases;++loop0)
        {
            anag = scan.next();
            anagLength = anag.length();
            minNumChanges = 0;
            if(anagLength%2==1)
                System.out.println(-1);
            else
            {
                anag1 = anag.substring(0,anagLength/2);
                anag2 = anag.substring(anagLength/2);
                Map<Character,Integer> letterOccs = new HashMap<>();
                
                for(loopI=0;loopI<anag1.length();++loopI)
                {
                    if(!letterOccs.containsKey(anag1.charAt(loopI)))
                        letterOccs.put(anag1.charAt(loopI),0);
                    
                    val = letterOccs.get(anag1.charAt(loopI));
                    letterOccs.put(anag1.charAt(loopI),val+1);
                    
                    if(!letterOccs.containsKey(anag2.charAt(loopI)))
                        letterOccs.put(anag2.charAt(loopI),0);
                        
                    val = letterOccs.get(anag2.charAt(loopI));
                    letterOccs.put(anag2.charAt(loopI),val-1);                        
                }
                
                for(int value:letterOccs.values())
                    minNumChanges += Math.abs(value);
                
                System.out.println(minNumChanges/2);
            }
        }
    }
}