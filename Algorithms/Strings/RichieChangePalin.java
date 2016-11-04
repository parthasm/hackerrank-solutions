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
        int n = in.nextInt();
        int k = in.nextInt();
        String number = in.next();
        in.close();
        
        int loopI,numChanges = 0;
        char c1 = 'a', c2 = 'b';
        StringBuilder st1 = new StringBuilder();
        StringBuilder st2 = new StringBuilder();
        Set<Integer> changedIndices = new HashSet<>();
        
        
        if(n==1 && k >= 1)
            System.out.println(9);
        else
        {
            for(loopI = 0; loopI < n/2; ++loopI)
            {
                c1 = number.charAt(loopI);
                c2 = number.charAt(n-(loopI+1));
                if(c1 > c2)
                {
                    st1.append(c1);
                    st2.append(c1);
                    changedIndices.add(loopI);
                    ++numChanges;
                }
                else if(c1 < c2)
                {
                    st1.append(c2);
                    st2.append(c2);
                    changedIndices.add(loopI);
                    ++numChanges;                
                }
                else
                {
                    st1.append(c1);
                    st2.append(c2);
                }
            }
            
            if(numChanges > k)
                System.out.println(-1);
            else
            {
                for(loopI=0;loopI< n/2; ++loopI)
                {
                    c1 = st1.charAt(loopI);
                    if(changedIndices.contains(loopI))
                    {
                        if(c1!='9' && numChanges < k)
                        {
                            st1.setCharAt(loopI,'9');
                            st2.setCharAt(loopI,'9');
                            ++numChanges;
                        }                                    
                    }
                    else
                    {
                        if(c1!='9' && numChanges < k-1)
                        {
                            st1.setCharAt(loopI,'9');
                            st2.setCharAt(loopI,'9');
                            numChanges+=2;
                        }                                                            
                    }
    
                }
                st2.reverse();    
                if(n%2==1)
                {
                    if(numChanges == k)
                        st1.append(number.charAt(n/2));
                    else
                        st1.append('9');
                }
                    
                st1.append(st2.toString());
                System.out.println(st1.toString());
            }
        }
    }
}
