

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        //  return countPaths(0,0, m, n);
        return countPathsDP(m, n);
    }

    /*
    Time Complexity : O((MN)^2)
    Space Complexity : O(MN)
    Approach :
    We can start dfs from the start corner, find the number of unique paths in right direction and in down direction. Add
    unique paths of both and return to the parent recursion call.
    */
    private int countPaths(int i, int j, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return 0;
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}};

        if (i == rows - 1 && j == cols - 1) return 1;
        int uniquePaths = 0;
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;
            uniquePaths += countPaths(nr, nc, rows, cols);
        }

        return uniquePaths;
    }


    /*
    Time Complexity : O(MN)
    Space Complexity : O(MN)
    Approach :
    We can instantiate the first row and fire column cells as 1, as there is one unique oath through those cells.
    Rest of the cells, we can add the unique path from top right and adjacent left cell. As unique path from this cell
    will be a sum of the unique paths from neighbor.
    */
    private int countPathsDP(int m, int n) {
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        for (int i = 0; i < m; i++) {
            grid[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            grid[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }

        return grid[m - 1][n - 1];
    }
}
