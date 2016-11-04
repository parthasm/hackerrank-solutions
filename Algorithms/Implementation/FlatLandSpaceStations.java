import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
/*
Another approach:
Uses an extra array, 
find minimum distances of all cities to a space station on the left 
do similarly for the right
For each city,
the minimum distace is the minimum of these 2 distances
*/
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int c[] = new int[m];
        for(int c_i=0; c_i < m; c_i++)
            c[c_i] = in.nextInt();
        
        in.close();
        
        Arrays.sort(c);
        
        int loopI,loopJ,maxDist = 0,minDist=n,currentMinDistCity = 0,dist;
        
        //If distance = spacestation city index - loopI; first spacestation city where sign changes, 
        //& the one before that are the 2 candidates for the closest spacestation city
        
        for(loopI = 0; loopI < n; ++loopI)
        {
            loopJ = currentMinDistCity;
            dist = c[loopJ] - loopI;
            if(dist == 0)
                continue;
            while(loopJ < m)
            {
                if(dist < 0)
                    ++loopJ;
                else if(dist == 0)
                    break;
                else
                {
                    if(loopJ > 0)
                        dist = Math.min(dist, loopI - c[loopJ-1]);    
                    break;
                }
                if(loopJ<m)
                    dist = c[loopJ] - loopI;
            }
            currentMinDistCity = Math.max(0,loopJ-1);
            
            System.out.println(loopI+" "+dist);
            
            if(dist > maxDist)
                maxDist = dist;
        }
        
        System.out.println(maxDist);
    }
}
