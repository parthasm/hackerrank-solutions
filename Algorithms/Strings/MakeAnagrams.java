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
        String str1 = scan.next();
        String str2 = scan.next();
        scan.close();
        
        int loopI,numDel=0,val=-1;
        char currentChar;
        Map<Character,Integer> mapLetterOccs1 = new HashMap<>();
        Map<Character,Integer> mapLetterOccs2 = new HashMap<>();
        
        for(loopI=0;loopI<str1.length();++loopI)
        {
            currentChar = str1.charAt(loopI);
            if(mapLetterOccs1.containsKey(currentChar))
                val = mapLetterOccs1.get(currentChar);
            else
                val = 0;
            mapLetterOccs1.put(currentChar,val+1);
        }
        
        for(loopI=0;loopI<str2.length();++loopI)
        {
            currentChar = str2.charAt(loopI);
            if(mapLetterOccs2.containsKey(currentChar))
                val = mapLetterOccs2.get(currentChar);
            else
                val = 0;
            mapLetterOccs2.put(currentChar,val+1);
        }

        for (Map.Entry<Character, Integer> entry : mapLetterOccs1.entrySet())
        {
            currentChar = entry.getKey();
            val = entry.getValue();
            if(mapLetterOccs2.containsKey(currentChar))
                numDel += Math.abs(val - mapLetterOccs2.get(currentChar));
            else
                numDel += val;
        }
        
        for (Map.Entry<Character, Integer> entry : mapLetterOccs2.entrySet())
        {
            currentChar = entry.getKey();
            val = entry.getValue();
            if(!mapLetterOccs1.containsKey(currentChar))
                numDel += val;
        }        
        System.out.println(numDel);        
    }
}