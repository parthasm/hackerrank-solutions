import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        Map<Integer, List<Integer>> indices = new HashMap<>();
        List<Integer> list = null;
        for(int A_i=0; A_i < n; A_i++)
        {
            A[A_i] = in.nextInt();
            list = indices.get(A[A_i]);
            if(list == null)
                list = new ArrayList<>();
            list.add(A_i);
            indices.put(A[A_i],list);
        }
        in.close();
        
        int minDist = n, dist;
        for (Map.Entry<Integer, List<Integer>> entry : indices.entrySet())
        {
            list = entry.getValue();
            for(int loopI = 0; loopI < list.size()-1; ++loopI)
            {
                dist = list.get(loopI+1) - list.get(loopI);
                if(dist < minDist)
                    minDist = dist;

                    
            }
        }
        if(minDist < n)
            System.out.println(minDist);
        else
            System.out.println(-1);
    }
}
