import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    private static void findOnes(int[][] ar, int row, int col, Set<String> positions)
    {
        int m = ar.length;
        int n = ar[0].length;
        positions.add(row+" "+col);
        ar[row][col] = 4;
        if(row > 0 && ar[row-1][col] == 1)
            findOnes(ar,row-1,col,positions);
        if(col > 0 && ar[row][col-1] == 1)
            findOnes(ar,row,col-1,positions);
        if(row < m-1 && ar[row+1][col] == 1)
            findOnes(ar,row+1,col,positions);
        if(col < n-1 && ar[row][col+1] == 1)
            findOnes(ar,row,col+1,positions);
        
        if(row > 0 && col > 0 && ar[row-1][col-1] == 1)
            findOnes(ar,row-1,col-1,positions);
        if(row > 0 && col < n-1 && ar[row-1][col+1] == 1)
            findOnes(ar,row-1,col+1,positions);
        if(row < m-1 && col > 0 && ar[row+1][col-1] == 1)
            findOnes(ar,row+1,col-1,positions);
        if(row < m-1 && col < n-1 && ar[row+1][col+1] == 1)
            findOnes(ar,row+1,col+1,positions);
        return;
    }
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in)   ;
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] ar = new int[m][n];
        int loopI,loopJ;
        
        for(loopI = 0; loopI < m; ++loopI)
        {
            for(loopJ = 0; loopJ < n; ++loopJ)
                ar[loopI][loopJ] = scan.nextInt();
        }
        scan.close();
        Set<String> positions = null;
        int maxSizeCluster = 0;
        for(loopI = 0; loopI < m; ++loopI)
        {
            for(loopJ = 0; loopJ < n; ++loopJ)
            {
                if(ar[loopI][loopJ] == 1)
                {
                    positions = new HashSet<>();
                    findOnes(ar,loopI,loopJ,positions);
                    if(maxSizeCluster < positions.size())
                        maxSizeCluster = positions.size();
                }    
            }
        }
        
        System.out.println(maxSizeCluster);
    }
}
