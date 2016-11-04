import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    private static int[] findMultiPaths(char[][] ar, int row, int col)
    {
        char c = ar[row][col];
        ar[row][col] = 'V';
        int[] newAr = new int[2];
        newAr[0] = 1;
        if(c=='*')
            return newAr;   
        int m = ar.length;
        int n = ar[0].length;
        int numPossiblePaths = 0 ;
        int numFruitfulPaths = 0 ;
        
        if(row > 0 && (ar[row-1][col] == '.' || ar[row-1][col] == '*'))
        {
            int[] tempAr = findMultiPaths(ar,row-1,col);
            if(tempAr[0]==1)
            {
                newAr[1] = tempAr[1];
                //System.out.println((row-1)+" "+col+" "+tempAr[1]);
                ++numFruitfulPaths;
            }
                
            ++numPossiblePaths;
        }
        if(col > 0 && (ar[row][col-1] == '.' || ar[row][col-1] == '*'))
        {
            int[] tempAr = findMultiPaths(ar,row,col-1);
            if(tempAr[0]==1)
            {
                newAr[1] = tempAr[1];
                //System.out.println(row+" "+(col-1)+" "+tempAr[1]);
                ++numFruitfulPaths;
            }
            ++numPossiblePaths;
        }
        if(row < m-1 && (ar[row+1][col] == '.' || ar[row+1][col] == '*'))
        {
            int[] tempAr = findMultiPaths(ar,row+1,col);
            if(tempAr[0]==1)
            {
                newAr[1] = tempAr[1];
                //System.out.println((row+1)+" "+col+" "+tempAr[1]);
                ++numFruitfulPaths;
            }
            ++numPossiblePaths;
        }
        if(col < n-1 && (ar[row][col+1] == '.' ||  ar[row][col+1] == '*'))
        {
            int[] tempAr = findMultiPaths(ar,row,col+1);
            if(tempAr[0]==1)
            {
                newAr[1] = tempAr[1];
                //System.out.println(row+" "+(col+1)+" "+tempAr[1]);
                ++numFruitfulPaths;
            }
            ++numPossiblePaths;
        }
        
        //Wrong turn
        if(numFruitfulPaths == 0)
        {
            newAr[0] = 0;
            return newAr;
        }
        
        //Dead end
        if(numPossiblePaths==0)
        {
            newAr[0] = 0;
            return newAr;
        }    
        
        //Single possible path, number of intersections remain unchanged
        if(numPossiblePaths == 1)
            return newAr;
        
        //Same possible path,but more than one turn available at current point
        //but number of intersections remain unchanged
        newAr[1]+= 1;
        return newAr;
    }
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numTestCases = scan.nextInt();
        for(int loop0 = 0; loop0 < numTestCases; ++loop0)
        {
            int loopI, loopJ,guess,numMultiPath = 0;
            int rowNum = scan.nextInt();
            int colNum = scan.nextInt();
            char[][] ar = new char[rowNum][colNum];
            
            for(loopI = 0; loopI < rowNum; ++loopI)
            {
                String s = scan.next();
                ar[loopI] = s.toCharArray();
            }
            for(loopI = 0; loopI < rowNum; ++loopI)
            {
                for(loopJ = 0; loopJ < colNum; ++loopJ)
                {
                    if(ar[loopI][loopJ] == 'M')
                    {
                        //The 1st position indicates if it is a feasible path or not
                        //by default it is feasible
                        numMultiPath = findMultiPaths(ar, loopI, loopJ)[1];
                        break;
                    }    
                }
                if(numMultiPath!=0)
                    break;
            }
            guess = scan.nextInt();
            if(numMultiPath == guess)
                System.out.println("Impressed");
            else
                System.out.println("Oops!");
            
        }
        scan.close();
    }
}