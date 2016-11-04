import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public static void insertIntoSorted(int[] ar) 
    {
        int n = ar.length;
        int V = ar[n-1];
        int loopI = n-2,loopJ;
        
        while(loopI>-1 && ar[loopI]>V)
        {
            ar[loopI+1]=ar[loopI];
            --loopI;
            
            for(loopJ=0;loopJ<n;++loopJ)
                System.out.print(ar[loopJ]+" ");
            System.out.println();
        }
        ar[loopI+1] = V;
        for(loopJ=0;loopJ<n;++loopJ)
            System.out.print(ar[loopJ]+" ");

        
    }
    
    
/* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
        }
        insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
 
