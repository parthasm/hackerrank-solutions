import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{

    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] ar = new int[n];
        int[] remNumAr = new int[k];
        int loopI;
        
        for(loopI=0;loopI<n;++loopI)
        {
            ar[loopI] = scan.nextInt();
            ++remNumAr[ar[loopI]%k];
        }
        scan.close();
        
        int finalSubsetSize = 0;
        if(remNumAr[0]>=1)
            ++finalSubsetSize;
        
        for(loopI=1;loopI<=k/2;++loopI)
        {
            if(k/loopI==2 && k%loopI==0)
            {
                if(remNumAr[loopI] >= 1)
                    ++finalSubsetSize;
                continue;
            }
                
            
            if(remNumAr[loopI] > remNumAr[k-loopI])
                finalSubsetSize += remNumAr[loopI];
            else
                finalSubsetSize += remNumAr[k-loopI];
        }
        
        System.out.println(finalSubsetSize);
        
    }
}