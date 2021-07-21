// Gives TLE on submission

class Solution {
    public int uniquePaths(int m, int n) {
        return helper(0, 0, m, n);
    }
    private int helper(int i, int j, int m, int n) {
        if(i == m || j == n) {
            return 0;
        }

        if(i == m - 1 && j == n - 1) {
            return 1;
        }

        // go right + down
        return helper(i, j + 1, m, n) + helper(i + 1, j, m, n);

    }
}