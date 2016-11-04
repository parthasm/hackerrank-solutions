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
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        int n3 = in.nextInt();
        int sum1 = 0, sum2 =0, sum3 = 0;
        int h1[] = new int[n1];
        for(int h1_i=0; h1_i < n1; h1_i++)
        {
            h1[h1_i] = in.nextInt();
            sum1 += h1[h1_i];
        }
        int h2[] = new int[n2];
        for(int h2_i=0; h2_i < n2; h2_i++)
        {
            h2[h2_i] = in.nextInt();
            sum2 += h2[h2_i];
        }
        int h3[] = new int[n3];
        for(int h3_i=0; h3_i < n3; h3_i++)
        {
            h3[h3_i] = in.nextInt();
            sum3 += h3[h3_i];
        }
        in.close();
        
        int c1=0,c2=0,c3=0;
        boolean reachedEqualStack = false;
        while(c1 < h1.length && c2 < h2.length && c3 < h3.length)
        {
            if(sum1 == sum2)
            {
                if(sum2 == sum3)
                {
                    System.out.println(sum1);
                    reachedEqualStack = true;
                    break;
                }
                    
                
                else if(sum2 > sum3)
                {
                    sum1 -= h1[c1];
                    ++c1;
                    sum2 -= h2[c2];
                    ++c2;
                }
                
                else
                {
                    sum3 -= h3[c3];
                    ++c3;
                }
            }
            
            else if(sum1 == sum3)
            {
                if(sum2 == sum3)
                {
                    System.out.println(sum1);
                    reachedEqualStack = true;
                    break;
                }
                    
                
                else if(sum2 > sum3)
                {
                    sum2 -= h2[c2];
                    ++c2;
                }
                
                else
                {
                    sum3 -= h3[c3];
                    ++c3;
                    sum1 -= h1[c1];
                    ++c1;
                }
            }
            
            else if(sum2 == sum3)
            {
                if(sum1 == sum3)
                {
                    System.out.println(sum1);
                    reachedEqualStack = true;
                    break;
                }
                    
                
                else if(sum1 > sum3)
                {
                    sum1 -= h1[c1];
                    ++c1;
                }
                
                else
                {
                    sum3 -= h3[c3];
                    ++c3;
                    sum2 -= h2[c2];
                    ++c2;
                }
            }   
            
            else if((sum1 > sum2 && sum2 > sum3) || (sum2>sum1 && sum1>sum3))
            {
                sum1 -= h1[c1];
                ++c1;
                sum2 -= h2[c2];
                ++c2;
            }

            else if((sum1 > sum3 && sum3 > sum2) || (sum3>sum1 && sum1>sum2))
            {
                sum1 -= h1[c1];
                ++c1;
                sum3 -= h3[c3];
                ++c3;
            }            
            
            else
            {
                sum2 -= h2[c2];
                ++c2;
                sum3 -= h3[c3];
                ++c3;                
            }
        }
        if(!reachedEqualStack)
            System.out.println(0);
    }
}
