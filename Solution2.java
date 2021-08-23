//Time complexity: O(m*n)
//Space complexity: O(min(m,n))

import java.util.*;

class Solution2 {
    public int uniquePaths(int m, int n) {        
        int dp[] = new int[Math.min(m,n)]; 
        
        Arrays.fill(dp, 1); 
        
        for(int i=1; i<Math.max(m,n); i++) {
            for(int j=1; j<Math.min(m,n); j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[Math.min(m,n)-1]; 
    }
}