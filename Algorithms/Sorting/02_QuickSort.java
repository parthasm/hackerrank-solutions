import java.util.*;
public class Solution 
{
    static void quickSortMain(int[] ar) 
    {
        List<Integer> liInt = new ArrayList<>();
        for(int loopI=0;loopI<ar.length;++loopI)
            liInt.add(ar[loopI]);
        quickSort(liInt);
        
    }
    private static void quickSort(List<Integer> liInt) 
    {
        if(liInt.size()<2)
            return;
            
        int pivot = liInt.get(0),loopI;
        ArrayList<Integer> greatList = new ArrayList<>();                
        ArrayList<Integer> lessList = new ArrayList<>();
        for(loopI=1;loopI<liInt.size();++loopI)
        {
            if(liInt.get(loopI)>pivot)
                greatList.add(liInt.get(loopI));
            else if(liInt.get(loopI)<pivot)
                lessList.add(liInt.get(loopI));
        }
     
  
        if(lessList.size()>=2)
            quickSort(lessList);  
        if(greatList.size()>=2)
            quickSort(greatList);
        
        //if you create a new ArrayList here & assign into liInt, pass by reference is ruined
        liInt.clear();
        
        for(loopI=0;loopI<lessList.size();++loopI)
            liInt.add(lessList.get(loopI));
        liInt.add(pivot);
        
        for(loopI=0;loopI<greatList.size();++loopI)
            liInt.add(greatList.get(loopI));
        for(loopI=0;loopI<liInt.size();++loopI)
            System.out.print(liInt.get(loopI)+" ");
        System.out.println();            
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
           quickSortMain(ar);
       }    
   }
