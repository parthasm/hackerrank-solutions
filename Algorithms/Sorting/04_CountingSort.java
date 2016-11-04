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
        int[] ar = new int[n];
        String[] stringAr = new String[n];
        for(int i=0;i<n;i++)
        {
            ar[i]=in.nextInt(); 
            stringAr[i] = in.next();
        }
        
        in.close();
        
        int loopI,loopJ;
        int[] startPos = new int[100];
        
        
        for(loopI=0;loopI<100;++loopI)
            startPos[loopI] = -1;
            
        for(loopI=0;loopI<n;++loopI)            
        {
            if(startPos[ar[loopI]]==-1)
                startPos[ar[loopI]] = loopI;
        }
        
        StringBuilder finalOutput = new StringBuilder();
        for(loopI=0;loopI<100;++loopI)
        {
            if(startPos[loopI]!=-1)
            {
                for(loopJ=startPos[loopI];loopJ<n;++loopJ)
                {
                    if(ar[loopJ]==loopI)
                    {
                        if(loopJ < n/2)
                            finalOutput.append("- ");
                        else
                            finalOutput.append(stringAr[loopJ]+" ");
                    }
                }
            }
        }
        System.out.println(finalOutput.toString());    
    }
}