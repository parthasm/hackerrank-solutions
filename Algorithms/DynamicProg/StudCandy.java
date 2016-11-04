import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    /*
    If the ratings are like 9 8 7 6 5
    then, we might start with 1, but 2nd person has to get less than the higher rated person
    when we adjust the 1st 2 and move to the 3rd, we again need an adjustment 
    The function below codes up this idea
    It is O(n^2)
    */
    private static int updateBackWithMinima(int[] arrRat)
    {
        int loopI,loopJ,minNumCand=0;
        int[] arrCan = new int[arrRat.length];
        arrCan[0] = 0;
        arrCan[1] = 1;
        for(loopI=2;loopI<arrRat.length;++loopI)
        {
            if(arrRat[loopI] > arrRat[loopI-1])
                arrCan[loopI] = arrCan[loopI-1]+1;
            else if(arrRat[loopI] == arrRat[loopI-1])
                arrCan[loopI] = 1;
            else
            {
                if(arrCan[loopI-1]==1)
                {
                    arrCan[loopI-1]=2;
                    loopJ=loopI-1;
                    while(loopJ>1 && arrCan[loopJ]==arrCan[loopJ-1] && arrRat[loopJ]<arrRat[loopJ-1])
                    {
                        arrCan[loopJ-1]+=1;
                        --loopJ;
                    }
                }
                arrCan[loopI] = 1;
            }
        }
        for(loopI=0;loopI<arrRat.length;++loopI)
            minNumCand += arrCan[loopI];
        return minNumCand;        
    }
/*    
    private static int findByMinimaTrendsDoublePass(int[] arrRat)
    {
        int loopI,loopJ,minNumCand=0,startIndex,endIndex;
        int[] arrCan = new int[arrRat.length];
        arrCan[0] = 0;
        boolean isMinimaTrend = false;
        List<Integer> listMinimas = new ArrayList<>();
        for(loopI=1;loopI<arrRat.length-1;++loopI)
        {
            if(arrRat[loopI] > arrRat[loopI+1])
            {
                if(!isMinimaTrend)
                {
                    isMinimaTrend = true;
                    listMinimas.add(loopI);
                }
            }
            else if(arrRat[loopI] < arrRat[loopI+1])
            {
                if(isMinimaTrend)
                {
                    isMinimaTrend=false;
                    listMinimas.add(loopI);
                }
            }
        }
        
        
        for(loopI=0;loopI<listMinimas.size();++loopI)
        {
            endIndex = listMinimas.get(loopI+1);
            startIndex = listMinimas.get(loopI);
            arrCan[endIndex]=1;
            for(loopJ=endIndex-1;loopJ>=startIndex;--loopJ)
            {
                if(arrRat[loopJ]>arrRat[loopJ+1])
                    arrCan[loopJ] = arrCan[loopJ+1]+1;
                else
                    arrCan[loopJ] = arrCan[loopJ+1];
            }
        }

    }
  */  
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int numChildren = scan.nextInt();
        int[] arrRat = new int[numChildren+1];
        int loopI;
        for(loopI=1;loopI<=numChildren;++loopI)
            arrRat[loopI] = scan.nextInt();
        scan.close();
        System.out.println(updateBackWithMinima(arrRat));
    }
}
