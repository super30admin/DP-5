// Time Complexity : O(2 ^ (m * n))
// Space Complexity : O(m * n)

class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0)
            return 0;
        return helper(0, 0, m ,n);
    }
    
    private int helper(int i, int j, int m, int n){
        //base
        if(i == m - 1 && j == n - 1)
            return 1;
        if(i == m || j == n)
            return 0;
        //logic
        return helper(i + 1, j, m , n) + helper(i, j + 1, m , n);
    }
}