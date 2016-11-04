import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner stdin=new Scanner(System.in);
        int n=stdin.nextInt(),k=stdin.nextInt();
        int prices[]=new int[n];
        for(int i=0;i<n;i++) prices[i]=stdin.nextInt();
        stdin.close();
        
        int answer = 0,loopI,runningPriceSum = 0 ;
        Arrays.sort(prices);
        
        for(loopI = 0; loopI < n; ++loopI)
        {
            if(runningPriceSum+prices[loopI] > k)
                break;
            runningPriceSum += prices[loopI];
            ++answer;
        }
        
        System.out.println(answer);
    }
}
