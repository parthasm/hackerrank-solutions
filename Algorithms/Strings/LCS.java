public class LCS
{
    private static int findLCSLen(String a, String b)
    {
        int m = a.length(), n = b.length(), loopI, loopJ;
        int[][] ar = new int[m+1][n+1];
        
        for(loopI = 0; loopI <= m; ++loopI)
        {
            for (loopJ = 0;loopJ <=n ;++loopJ ) 
            {
                if(loopI == 0 || loopJ == 0)
                    ar[loopI][loopJ] = 0;
                else
                {
                    if(a.charAt(loopI-1) == b.charAt(loopJ-1))
                    {
                        int t = Math.max(ar[loopI-1][loopJ-1]+1,ar[loopI][loopJ-1]);
                        ar[loopI][loopJ] = Math.max(t,ar[loopI-1][loopJ]);
                    }
                    else
                        ar[loopI][loopJ] = Math.max(ar[loopI][loopJ-1],ar[loopI-1][loopJ]);
                }
            }
        }
        
        return ar[m][n];
    }
    public static void main(String[] args)
    {
        String a = "ABAC";
        String b = "AGCA";
        
        int ans = findLCSLen(a,b);
        System.out.println(ans);
    }
}