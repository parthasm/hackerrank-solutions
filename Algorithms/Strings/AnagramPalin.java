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
        An anagram of a palindrome would have even number of occurences of all characters
        when the palindrome & its anagram is of even length
        For a palindrome & its anagram of odd length,
        there has to be one character with odd number of occurences, 
        rest of the characters would have even number of occurences like before
        */
        Scanner myScan = new Scanner(System.in);
        String inputString = myScan.nextLine();
        String ans="YES";
        // Assign ans a value of YES or NO, depending on whether or not inputString satisfies the required condition
        
        int loopI,val;
        char currentChar;
        Map<Character,Integer> letterOccs = new HashMap<>();
        for(loopI=0;loopI<inputString.length();++loopI)
        {
            currentChar = inputString.charAt(loopI);
            if(letterOccs.containsKey(currentChar))
            {
                val = letterOccs.get(currentChar);
                letterOccs.put(currentChar,val+1);
            }
            else
                letterOccs.put(currentChar,1);
        }
        
        if(inputString.length()%2==0)
        {
            for(int value:letterOccs.values())
            {
                if(value%2==1)
                {
                    ans = "NO";
                    break;
                }
            }
        }
        else
        {
            boolean foundTheOddOne = false;
            for(int value:letterOccs.values())
            {
                if(value%2==1)
                {
                    if(!foundTheOddOne)       
                        foundTheOddOne = true;
                    else
                    {
                        ans = "NO";
                        break;
                    }
                }
            }
            if(!foundTheOddOne)
                ans = "NO";
        }
        System.out.println(ans);
        myScan.close();
    }
}
