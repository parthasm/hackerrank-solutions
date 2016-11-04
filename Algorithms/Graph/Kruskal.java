import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Edge
{
    private int firstVertex;
    private int secondVertex;
    private int weight;
    
    public Edge(int f,int s, int w)
    {
        if(f > s)
        {
            s+= f;
            f = s - f;
            s-= f;
        }
        
        this.firstVertex = f;
        this.secondVertex = s;
        this.weight = w;
    }
    
    public static Comparator<Edge> COMPARE_EDGES = new Comparator<Edge>()
    {
        public int compare(Edge e1, Edge e2) 
        {   
            Integer x1 = new Integer(e1.getWeight());
            Integer x2 = new Integer(e2.getWeight());
            if(!x1.equals(x2))
                return x1.compareTo(x2);
            Integer y1 = new Integer(e1.getWeight()+e1.getFirstVertex()+e1.getSecondVertex());
            Integer y2 = new Integer(e2.getWeight()+e2.getFirstVertex()+e2.getSecondVertex());
            return y1.compareTo(y2);
            
        }
    }; 
    
    public int getFirstVertex()
    {
        return this.firstVertex;
    }
    
    public int getSecondVertex()
    {
        return this.secondVertex;
    }    
    
    public int getWeight()
    {
        return this.weight;
    }   
    
    @Override
    public int hashCode() 
    {
        int result = (this.firstVertex * 100) + (this.secondVertex * 10) + (this.weight);
        return result;
    }    
    
    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Edge))
            return false;
        Edge other = (Edge) obj;
        if(this.hashCode() != other.hashCode())
            return false;
        return true;
    }    
}

public class Solution 
{
    private static boolean DFS(Map<Integer,Map<Integer,Integer>> temp, Set<Integer> verticesCovered, Set<Edge> edgesCovered, int x)
    {
        Map<Integer,Integer> vertexMap = temp.get(x);
        verticesCovered.add(x);
        for(Map.Entry<Integer,Integer> entry: vertexMap.entrySet())
        {
            Edge edge = new Edge(x,entry.getKey(),entry.getValue());
            if(!edgesCovered.contains(edge) && verticesCovered.contains(entry.getKey()))
                return false;
            edgesCovered.add(edge);
            if(verticesCovered.contains(entry.getKey()))
                continue;
            boolean flag = DFS(temp,verticesCovered,edgesCovered,entry.getKey());
            if(!flag)
                return false;
        }
        return true;
    }
    private static boolean hasCycle(Map<Integer,Map<Integer,Integer>> graph, Edge edge)
    {
        
        Map<Integer, Map<Integer,Integer>> temp = new HashMap<>();
        for(Map.Entry<Integer, Map<Integer,Integer>> entry : graph.entrySet())
            temp.put(entry.getKey(), new HashMap<Integer, Integer>(entry.getValue()));

        int x = edge.getFirstVertex();
        int y = edge.getSecondVertex();
        int r = edge.getWeight();
        Map<Integer,Integer> vertexMap = temp.get(x);
        if(vertexMap == null)
            vertexMap = new HashMap<>();
        Integer wei = vertexMap.get(y);
        if(wei == null)
            wei = 100000;
        if(wei > r)
            vertexMap.put(y,r);
        temp.put(x,vertexMap);
        
        vertexMap = temp.get(y);
        if(vertexMap == null)
            vertexMap = new HashMap<>();
        wei = vertexMap.get(x);
        if(wei == null)
            wei = 100000;
        if(wei > r)
            vertexMap.put(x,r);
        temp.put(y,vertexMap);
        
        Set<Integer> verticesCovered = new HashSet<>();
        Set<Edge> edgesCovered = new HashSet<>();
        return !DFS(temp,verticesCovered,edgesCovered, x);
 
    }
    
    private static boolean edgeExists(Map<Integer,Map<Integer,Integer>> graph, Edge edge)
    {
        int x = edge.getFirstVertex();
        int y = edge.getSecondVertex();
        Map<Integer,Integer> vertexMap = graph.get(x);
        if(vertexMap == null)
            return false;
        if(vertexMap.get(y)!= null)
            return true;
        return false;
    }
    
    public static void main(String[] args) 
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int loopI,vertex,edgeLength,minVertex = -1,minEdge = 100000,minSumEdge=0;
        List<Edge> edges = new ArrayList<>();        
        Edge edge;
        
        for(loopI = 0; loopI < m; ++loopI)
        {
            int x = scan.nextInt();    
            int y = scan.nextInt();
            int r = scan.nextInt();
            edge =  new Edge(x,y,r);
            edges.add(edge);
        }
        
        int s = scan.nextInt();
        scan.close();
        
        Collections.sort(edges,Edge.COMPARE_EDGES);
        Map<Integer,Map<Integer,Integer>> graph = new HashMap<>();
        Map<Integer,Integer> vertexMap = null;
        for(loopI = 0; loopI < m; ++loopI)
        {
            edge = edges.get(loopI);
            if(hasCycle(graph,edge))
                continue;
            int x = edge.getFirstVertex();
            int y = edge.getSecondVertex();
            int r = edge.getWeight();
            vertexMap = graph.get(x);
            if(vertexMap == null)
                vertexMap = new HashMap<>();
            Integer wei = vertexMap.get(y);
            if(wei == null)
                wei = 100000;
            if(wei > r)
                vertexMap.put(y,r);
            //System.out.println(x+" "+y+" "+r);
            graph.put(x,vertexMap);
            
            vertexMap = graph.get(y);
            if(vertexMap == null)
                vertexMap = new HashMap<>();
            wei = vertexMap.get(x);
            if(wei == null)
                wei = 100000;
            if(wei > r)
                vertexMap.put(x,r);
            //System.out.println(x+" "+y+" "+r);
            graph.put(y,vertexMap);
            if(graph.size()==n)
            {
                int edgeCount = 0;
                for(Map.Entry<Integer,Map<Integer,Integer>> entry: graph.entrySet())
                    edgeCount += entry.getValue().size();
                
                if(edgeCount == 2*(n-1))
                    break;
            }
        }
        //System.out.println(graph);
        for(Map.Entry<Integer,Map<Integer,Integer>> entry: graph.entrySet())        
        {
            vertexMap = entry.getValue();
            for(Map.Entry<Integer,Integer> nestedEntry: vertexMap.entrySet())
                minSumEdge += nestedEntry.getValue();
        }
        System.out.println(minSumEdge/2);
    }
}
