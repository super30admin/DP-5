//TC = O(N*M)
//SC = O(N)
import java.util.*;
public class UniquePaths
{
    public static int uniquePaths(int m, int n) {
        
        if(m == 0 || n == 0) return 0;
        
        int[] dp = new int[n];
        
        Arrays.fill(dp,1);
        
        for(int i = m - 2;i>=0;i--)
        {
            for(int j = n - 2;j>=0;j--)
            {
                dp[j] = dp[j] + dp[j+1];
            }
        }
        
        return dp[0];
    }

    public static void main(String args[])
    {
        System.out.println(uniquePaths(3, 7));
    }
}