// Time Complexity -> O(m*n)
// Space Complexity -> O(m*n)
class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return helper(m,n,0,0);
    }

    public int helper(int m, int n, int r, int c){
        if(r == m-1 && c == n-1) return 1;
        if(r >= m || c >= n) return 0;
        if(memo[r][c] != 0) return memo[r][c]
;
        int result = helper(m,n,r+1, c) + helper(m, n, r, c+1);
        memo[r][c] = result;
        return result;
    }
}
