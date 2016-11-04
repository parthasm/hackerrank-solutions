import java.util.*;
public class Solution 
{
       
    static void partition(int[] ar) 
    {
        List<Integer> greatList = new ArrayList<>();                
        List<Integer> lessList = new ArrayList<>();
        List<Integer> equalList = new ArrayList<>();
        
        equalList.add(ar[0]);
        int loopI;
        
        for(loopI=1;loopI<ar.length;++loopI)
        {
            if(ar[loopI]>ar[0])
                greatList.add(ar[loopI]);
            else if(ar[loopI]<ar[0])
                lessList.add(ar[loopI]);
            else
                equalList.add(ar[loopI]);
        }
        
        for(loopI=0;loopI<lessList.size();++loopI)
            System.out.print(lessList.get(loopI)+" ");
        for(loopI=0;loopI<equalList.size();++loopI)
            System.out.print(equalList.get(loopI)+" ");
        for(loopI=0;loopI<greatList.size();++loopI)
            System.out.print(greatList.get(loopI)+" ");
        
    }   
 
 static void printArray(int[] ar) {
         for(int n: ar){
            System.out.print(n+" ");
         }
           System.out.println("");
      }
       
      public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int n = in.nextInt();
           int[] ar = new int[n];
           for(int i=0;i<n;i++){
              ar[i]=in.nextInt(); 
           }
           partition(ar);
       }    
   }
