# DP-5

## Problem1: (https://leetcode.com/problems/word-break/)

Explain approach in 3 lines: In this solution we are using dynamic programming to determine if the string can be segmented into words from the given dictionary. We are building dp array where dp[i] is basically a substring s[0:i] which can be segmented. For each i we are checking all the possible substrings s[j:i] where j < i and if dp[j] is true and the substring is in the dictionary we are setting dp[i] to true. 

Time complexity: O(n^2) where n is the length of the string s and we are using nested loop to iterate over all possible substrings.

Space complexity: O(n) which is an additional space to store DP array.

Approached Code: 

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        // return helper(s, set);

        int l = s.length();

        boolean[] dp = new boolean[l+1];
        dp[0] = true;

        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[l];
    }

    private boolean helper(String s, HashSet<String> set) {
        // base
        if(s.length() == 0) return true;

        // logic
        for(int i = 0; i < s.length(); i++) {
            String curr = s.substring(0, i+1);

            if(set.contains(curr) && helper(s.substring(i+1), set)) {
                return true;
            }
        }

        return false;
    }
}



## Problem2: (https://leetcode.com/problems/unique-paths/)

Explain approach in 3 lines : In this approach we are using dynamic programming to calculate the number of unique paths from bottom-right corner to top-left corner. In this we will fill a DP table where each cell will represent number of unique paths to reach the destination cell from that cell. The value of each cell would be sum of the paths from cell directly below and the cell directly to the right.

Time complexity : O(m*n) as we are iterating through each cell in the DP table exactly once.

Space complexity : O(m*n) as we are using additional space for the DP table.

Approached Code: 

class Solution {
    int[][] memo;

    public int uniquePaths(int m, int n) {
        // this.memo = new int[m][n];
        // memo[m-1][n-1] = 1;
        // return helper(0, 0, m, n);

        int[][] dp = new int[m+1][n+1];

        dp[m-1][n-1] = 1;

        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >=0; j--) {
                if(i == m-1 && j == n-1) continue;

                dp[i][j] = dp[i+1][j] + dp[i][j+1];
             }
        }

        return dp[0][0];
    }

    private int helper(int i, int j, int m, int n) {
        // base
        if(i == m || j == n) return 0;
        // if(i == m-1 || j == n-1) return 1;
        if(memo[i][j] != 0) return memo[i][j];

        // logic
        int right = helper(i, j+1, m ,n);
        int bottom = helper(i+1, j, m, n);

        memo[i][j] = right + bottom;

        // return right + bottom;

        return memo[i][j];
    }
}


