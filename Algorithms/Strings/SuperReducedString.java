import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SuperReducedString
{
    private static boolean isFinalReducedForm(StringBuilder st)
    {
        String s = st.toString();
        Map<Character,List<Integer>> indices = new HashMap<>();
        List<Integer> list = null;
        int loopI, loopJ, n = s.length();
        char c = '0';
        for(loopI = 0; loopI < n; ++loopI)
        {
            c = s.charAt(loopI);
            list = indices.get(c);
            
            if(list == null)
                list = new ArrayList<>();
            
            list.add(loopI);
            indices.put(c,list);
        }
        
        for (Map.Entry<Character, List<Integer>> entry : indices.entrySet())
        {
            c = entry.getKey();
            list = entry.getValue();
            for(loopJ = 0; loopJ < list.size() - 1; ++loopJ)
            {
                if(list.get(loopJ)+1 == list.get(loopJ+1))
                    return false;
            }
        }
        
        return true;
    }
    
    private static void reduceString(StringBuilder s)
    {
        String tempString = s.toString();
        s.setLength(0);
        int loopI=0, n = tempString.length(),loopJ, numOccurences = 0;
        
        while(loopI < n)
        {
            char c = tempString.charAt(loopI);
            loopJ = loopI+1;
            numOccurences = 1;
            while(loopJ < n && tempString.charAt(loopJ)==c)
            {
                ++numOccurences;
                ++loopJ;
            }
            
            if(numOccurences%2==1)    
                s.append(c);
            loopI = loopJ;
        }        
    }

/*
Algorithm: 
1) Remove as many consecutive duplicates as possible, 
2) check if final reduced form or not, 
3) If not, step 1)

Alternate way: use a stack
if S[i] == top, remove top & move to S[i+1] position
else put S[i] becomes new top & move to S[i+1] position
*/
    
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        scan.close();
        
        StringBuilder st = new StringBuilder(s);
        while(!isFinalReducedForm(st))
            reduceString(st);
        
        if(st.length() == 0)
            System.out.println("Empty String");
        else
            System.out.println(st.toString());
        

        
    }
}