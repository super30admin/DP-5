/* 
Time Complexity: O(m * n) 

Space Complexity: O(m * n)
   - Memoization table stores results for each cell.
   - Recursion stack depth up to (m+n), but bounded by O(m * n).

Did this code successfully run on Leetcode: Yes
*/

// Approach:
// - Use recursion with memoization.
// - At (i, j), base case: if we reach destination (m-1, n-1), return 1.
// - If out of bounds, return 0.
// - Otherwise, number of paths = paths going right (i, j+1) + paths going down (i+1, j).
// - Store results in memo[i][j] to avoid recomputation.
// - Answer = helper(0, 0).


public class UniquePaths {
    int[][] memo;

    public int uniquePaths(int m, int n) {
        this.memo = new int[m][n];
        return helper(0, 0, m, n);
    }

    private int helper(int i, int j, int m, int n){
        if(i == m - 1 && j == n - 1) return 1; //Base case, when we reach the dest

        if(i == m || j == n) return 0; //out of boundary

        if(memo[i][j] != 0) return memo[i][j];

        int case0 = helper(i, j+1, m, n); //go right
        int case1 = helper(i+1, j, m, n); //go down

        memo[i][j] = case0 + case1;

        return case0 + case1;
    }
}
