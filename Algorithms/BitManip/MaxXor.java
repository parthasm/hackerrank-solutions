import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
/*
 * Complete the function below.
 */

    static int maxXor(int l, int r) 
    {
        int maxXorValue = 0,xorVal;
        for(int loopI=l;loopI<r;++loopI)
        {
            for(int loopJ=loopI+1;loopJ<=r;++loopJ)
            {
                xorVal = loopI^loopJ;
                if(xorVal > maxXorValue)
                    maxXorValue = xorVal;
            }    
        }
        return maxXorValue;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());
        
        int _r;
        _r = Integer.parseInt(in.nextLine());
        
        res = maxXor(_l, _r);
        System.out.println(res);
        
    }
}
