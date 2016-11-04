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
        int numNums = scan.nextInt();
        int numba;
        for(int loopI=0;loopI<numNums;++loopI)
        {
            numba = scan.nextInt();
            numba^= -1;
            System.out.println(~numba);
        }
        scan.close();
    }
}
