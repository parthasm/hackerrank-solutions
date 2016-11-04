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
        int n = scan.nextInt();
        int m = scan.nextInt();
        Map<Integer,Map<Integer,Integer>> graph = new HashMap<>();
        Map<Integer,Integer> vertexMap = null;
        int loopI,vertex,edgeLength,minVertex = -1,minEdge = 100000,minSumEdge=0;
        
        for(loopI = 0; loopI < m; ++loopI)
        {
            int x = scan.nextInt();    
            int y = scan.nextInt();
            int r = scan.nextInt();
            vertexMap = graph.get(x);
            if(vertexMap == null)
                vertexMap = new HashMap<>();
            Integer edge = vertexMap.get(y);
            if(edge == null)
                edge = 100000;
            if(edge > r)
                vertexMap.put(y,r);
            graph.put(x,vertexMap);
            
            vertexMap = graph.get(y);
            if(vertexMap == null)
                vertexMap = new HashMap<>();
            edge = vertexMap.get(x);
            if(edge == null)
                edge = 100000;
            if(edge > r)
                vertexMap.put(x,r);
            graph.put(y,vertexMap);
        }
        
        int s = scan.nextInt();
        scan.close();
        
        Set<Integer> verticesCovered = new HashSet<>();
        verticesCovered.add(s);
        
        while(verticesCovered.size() < n)
        {
            minVertex = -1;
            minEdge = 100000;
            for(int v: verticesCovered)
            {
                vertexMap = graph.get(v);
                for(Map.Entry<Integer,Integer> entry: vertexMap.entrySet())
                {
                    if(!verticesCovered.contains(entry.getKey()) && entry.getValue() < minEdge)
                    {
                        minVertex = entry.getKey();
                        minEdge = entry.getValue();
                    }
                }
            }
            if(minVertex!=-1)
            {
                minSumEdge += minEdge;
                verticesCovered.add(minVertex);
                //System.out.println(minVertex);
            }
            else
            {
                System.out.println("Error!");
                break;
            }
        }
        
        System.out.println(minSumEdge);
    }
}