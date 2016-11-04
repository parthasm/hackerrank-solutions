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
        int numTestCases = scan.nextInt();
        for(int loop0=0;loop0<numTestCases;++loop0)
        {
            int n = scan.nextInt();
            int m = scan.nextInt();
            int v1,v2;
            Map<Integer,Set<Integer>> edgeMap = new HashMap<>();
            Set<Integer> setV1 = null;
            Set<Integer> setV2 = null;
            int loopI;
            
            int[] distanceAr = new int[n+1];
            for(loopI=1;loopI<=n;++loopI)
                distanceAr[loopI] = -1;
            for(loopI=0;loopI<m;++loopI)
            {
                v1 = scan.nextInt();
                v2 = scan.nextInt();
                if(edgeMap.get(v1)==null)
                    setV1 = new HashSet<>();
                else
                    setV1 = edgeMap.get(v1);
                    
                if(edgeMap.get(v2)==null)
                    setV2 = new HashSet<>();
                else
                    setV2 = edgeMap.get(v2);                    
                    
                setV1.add(v2);
                setV2.add(v1);
                
                edgeMap.put(v1,setV1);
                edgeMap.put(v2,setV2);
            }
            int startingNode = scan.nextInt();
            distanceAr[startingNode] = 0;
            
            LinkedList<Integer> vertQueBFS = new LinkedList<>();
            vertQueBFS.add(startingNode);
            
            int currVert=0;
            
            while(vertQueBFS.size()>0)
            {
                currVert = vertQueBFS.poll();
                for(int v:edgeMap.get(currVert))
                {
                    if(distanceAr[v]==-1)
                    {
                        distanceAr[v] = distanceAr[currVert]+6;
                        vertQueBFS.add(v);
                    }
                }
            }
            
            for(loopI=1;loopI<=n;++loopI)
            {
                if(loopI==startingNode)
                    continue;
                System.out.print(distanceAr[loopI]+" ");
            }
            System.out.println();
        }
        scan.close();
    }
}