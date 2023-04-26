//Time: O(mn)
//Space O(n)

class Solution {
    public int[] memo;
    public int uniquePaths(int m, int n) {
        this.memo = new int[n];
        for(int i = 0; i < n; i++) {
            memo[i] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = n-2; j >= 0; j--) {
                int temp = memo[j];
                memo[j] = temp + memo[j+1];
            }
        }
        return memo[0];
    }
}