import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution 
{
    private static int lonelyInteger(int[] a) 
    {
        Set<Integer> nums = new HashSet<>();
        int retVal=0;
        for(int loopI=0;loopI<a.length;++loopI)
        {
            if(nums.contains(a[loopI]))
                nums.remove(a[loopI]);
            else
                nums.add(a[loopI]);
        }
        for(int num:nums)
        {
            retVal = num;
            break;
        }
        return retVal;
    }
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a));
    }

}
