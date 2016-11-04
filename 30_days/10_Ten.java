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
        StringBuilder binNumSB = new StringBuilder();
        
        while(n>0)
        {
            binNumSB.insert(0,n%2);
            n /= 2;
        }
        
        String binNum = binNumSB.toString();
        int loopI=0,counter=0,maxCounter=0;
        boolean oneZone = false;
        
        while(loopI < binNum.length())
        {
            if(binNum.charAt(loopI)=='1')
            {
                if(!oneZone)
                {
                    counter = 1;
                    oneZone = true;
                }
                else
                    ++counter;
            }
            else if(binNum.charAt(loopI)=='0')
            {
                if(oneZone)
                    oneZone = false;
                counter = 0;
            }
            else
            {
                System.out.println("An error has occured.");
                break;
            }
            
            if(maxCounter < counter)
                maxCounter = counter;
            
            ++loopI;
        }
        
        System.out.println(maxCounter);
    }
}
