import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String B = in.next();
        in.close();
        
        int loopI=0,minChange = 0;
        char c1='a',c2='a',c3='a';
        while(loopI<n)
        {
            c1 = B.charAt(loopI);
            if(loopI<n-1)
                c2 = B.charAt(loopI+1);
            if(loopI < n-2)
                c3 = B.charAt(loopI+2);
            if(loopI < n-2 && c1 == '0' && c2 == '1' && c3 == '0')
            {
                ++minChange;
                loopI+=3;
            }
            else
                ++loopI;
        }
        
        System.out.println(minChange);
    }
}
