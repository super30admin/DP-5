// Time Complexity : O(m*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class UniquePaths {
//    class Solution {
//        int[][] memo;
//        public int uniquePaths(int m, int n) {
//            this.memo = new int[m][n];
//            return helper(0, 0, m, n, memo);
//        }
//
//        private int helper(int i, int j, int m, int n, int[][] memo){
//            //base
//            if(i >= m || j >= n)
//                return 0;
//            if(i == m - 1 && j == n - 1)
//                return 1;
//            //logic
//            //right
//            int case1 = 0;
//            if(j < n - 1){
//                if(memo[i][j + 1] == 0){
//                    memo[i][j + 1] = helper(i, j + 1, m, n, memo);
//                }
//                case1 = memo[i][j + 1];
//            }
//
//            //down
//            int case2 = 0;
//            if(i < m - 1){
//                if(memo[i + 1][j] == 0){
//                    memo[i + 1][j] = helper(i + 1, j, m, n, memo);
//                }
//                case2 = memo[i + 1][j];
//            }
//
//            return case1 + case2;
//        }
//    }
class Solution {
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        for(int j = n - 1; j >= 0; j--){
            dp[j] = 1;
        }

        for(int i = 0 ; i < m-1; i++){
            for(int j = n - 2; j >= 0; j--){
                dp[j] = dp[j] + dp[j+1];
            }
        }

        return dp[0];
    }
}
}
