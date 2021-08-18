# DP-5

## Problem1: (https://leetcode.com/problems/word-break/)

//Time Complexity = O(N^4)
//Space Complexity = O(M) - Number of words in word dict

class Solution {
public boolean wordBreak(String s, List<String> wordDict) {
if(s == null || s.length() == 0) {
return false;
}
HashSet<String> set = new HashSet<>(wordDict);
int n = s.length();
boolean[] dp = new boolean[n+1];
dp[0] = true;
for(int i = 1; i <= n; i++) {
for(int j = 0; j < i; j++) {
if(dp[j] == true && set.contains(s.substring(j,i))) {
dp[i] = true;
break;
}
}
}
return dp[n];
}
}

## Problem2: (https://leetcode.com/problems/unique-paths/)

//Time Complexity = O(M*N)
//Space Complexity = O(M*N)

class Solution {
public int uniquePaths(int m, int n) {
if(m == 0 || n == 0) {
return 0;
}
int[][] dp = new int[m+1][n+1];
dp[m-1][n-1] = 1;

        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(i == m-1 && j == n-1) {
                    continue;
                } else {
                    dp[i][j] = dp[i+1][j] + dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }

}
