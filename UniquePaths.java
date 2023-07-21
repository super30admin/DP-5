public class UniquePaths {
    int[][] memo;

    public int uniquePaths(int m, int n) {
        this.memo = new int[m][n];
        return helper(0, 0, m, n);
    }

    private int helper(int i, int j, int m, int n) {
        if (i == m || j == n)
            return 0;
        if (i == m - 1 && j == n - 1)
            return 1;

        int case1 = 0;
        if (j < n - 1) {
            if (memo[i][j + 1] == 0) {
                memo[i][j + 1] = helper(i, j + 1, m, n);
            }
            case1 = memo[i][j + 1];
        }

        int case2 = 0;
        if (i < m - 1) {
            if (memo[i + 1][j] == 0) {
                memo[i + 1][j] = helper(i + 1, j, m, n);
            }
            case2 = memo[i + 1][j];
        }
        return case1 + case2;
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();

        // Example input m and n
        int m = 3;
        int n = 7;

        int uniquePathsCount = solution.uniquePaths(m, n);
        System.out.println("Number of unique paths: " + uniquePathsCount);
    }
}
