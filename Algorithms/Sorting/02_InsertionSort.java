import java.io.*;
import java.util.*;

public class Solution {

    public static void insertionSortPart2(int[] ar)
    {       
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
        int loopI,loopJ,n = ar.length,V;
        for(loopI=1;loopI<n;++loopI)   
        {
            V = ar[loopI];
            loopJ = loopI-1;
            while(loopJ>-1 && ar[loopJ]>V)
            {
                ar[loopJ+1]=ar[loopJ];
                --loopJ;
            }
            ar[loopJ+1] = V;
            
            for(loopJ=0;loopJ<n;++loopJ)
                System.out.print(ar[loopJ]+" ");
            System.out.println();    
        }
    }  
    
    
      
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
       insertionSortPart2(ar);    
                    
    }    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
}
