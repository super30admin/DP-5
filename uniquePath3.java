//TC: O(MN) 
//SC: O(N) whichever is bigger either row or col


//dp array approach
import java.util.Arrays;
class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0)
            return 0;
        
        //we use whichever is bigger one
        if(n > m)
            return uniquePaths(n, m);
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        //start from end, curr cell is down and the j + 1 cell is right 
        for(int i = m - 2; i >= 0; i--){
            for(int j = n - 2; j >= 0; j--){
                dp[j] = dp[j] + dp[j+1];
            }
        }  
        return dp[0];
    }
    
}