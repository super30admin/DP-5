//Time Complexity: O(m*n)
//SPace Complexity: O(n)
import java.util.*;
class Solution {
    public int uniquePaths(int m, int n) {
        if (m ==0 || n==0) return 0;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i <= m-2; i++) {
            for (int j = n-2; j >=0; j--) {
                dp[j] = dp[j] + dp[j+1];
            }
        }

        return dp[0];
    }
}
