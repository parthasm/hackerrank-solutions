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
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++)
            c[c_i] = in.nextInt();
        
        in.close();
        
        int loopI=0,minJumps=0;
        while(loopI<n-1)
        {
            if(loopI<n-2)
            {
                if(c[loopI+2]==1)
                    ++loopI;

                else
                    loopI += 2;
            
            }
            else if(loopI==n-2)
                ++loopI;
            ++minJumps;    
        }
        System.out.println(minJumps);
    }
}
