import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{

/*
Algorithm: use a stack
if S[i] == top, remove top & move to S[i+1] position
else put S[i] becomes new top & move to S[i+1] position
*/
    
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        scan.close();
        
        LinkedList<Character> stacked = new LinkedList<>();
        
        for(int loopI = 0; loopI < s.length(); ++loopI)
        {
            char c = s.charAt(loopI);
            
            if(stacked.size() == 0 || stacked.getLast()!=c)
            {
                stacked.add(c);
                //System.out.println("Added char: "+c);
            }
                
            else
            {
                c = stacked.pollLast();
                //System.out.println("Removed char: "+c);
            }
        }
        
        for(char c: stacked)
            System.out.print(c);
        
        if(stacked.size() == 0)
            System.out.print("Empty String");

    }
}