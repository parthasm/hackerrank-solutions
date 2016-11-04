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
        for(int a0 = 0; a0 < n; a0++)
        {
            String s = in.next();
            Set<Character> chars = new HashSet<>();
            for(int loopI = 0; loopI < s.length(); ++loopI)
                chars.add(s.charAt(loopI));
            
            System.out.println(chars.size());
        }
    }
}
