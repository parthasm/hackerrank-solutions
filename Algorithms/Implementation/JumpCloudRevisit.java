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
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++)
            c[c_i] = in.nextInt();
        in.close();
        
        int loopI=0, energyUsed = 0;
        loopI = (loopI+k)%n;
        if(c[loopI]==1)
            energyUsed += 3;
        else
            ++energyUsed;
        
        while(loopI!=0)
        {
            loopI = (loopI+k)%n;
            if(c[loopI]==1)
                energyUsed += 3;
            else
                ++energyUsed;            
        }
        
        System.out.println(100-energyUsed);
        
    }
}
