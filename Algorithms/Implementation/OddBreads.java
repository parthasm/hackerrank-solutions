import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B[] = new int[N];
        for(int B_i=0; B_i < N; B_i++)
            B[B_i] = in.nextInt();
        in.close();
        
        int loopI, numOdd = 0, lastOddIndex = -1, minBread = 0;
        
        for(loopI = 0; loopI < N; ++loopI)
        {
            if(B[loopI] % 2 == 1)
            {
                if(numOdd % 2 == 0)
                    lastOddIndex = loopI;
                else
                {
                    minBread += (2*(loopI - lastOddIndex));
                    lastOddIndex = -1;
                }
                ++numOdd;
            }
        }
        
        if(numOdd % 2 == 1)
            System.out.println("NO");
        else
            System.out.println(minBread);
    }
}
