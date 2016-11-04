import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        in.close();
        int counter = 0;
        for(int loopI = 0; loopI < s.length(); ++loopI)
        {
            char c = s.charAt(loopI);
            if(c >= 65 && c <= 90)
                ++counter;
        }
        
        System.out.println(counter+1);
    }
}
