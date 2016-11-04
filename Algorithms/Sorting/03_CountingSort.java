import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public static void main(String[] args) 
    {
        String waste;
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++)
        {
            ar[i]=in.nextInt(); 
            waste = in.next();
        }
        
        in.close();
        
        int[] countAr = new int[100];
        int loopI,runningSum=0;
        
        for(loopI=0;loopI<n;++loopI)
            countAr[ar[loopI]]++;
        
        for(loopI=0;loopI<100;++loopI)
        {
            runningSum += countAr[loopI];
            System.out.print(runningSum+" ");
        }
            
    }
}