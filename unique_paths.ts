// TC: O(mxn): SC: O(mxn)
function uniquePaths(m: number, n: number): number {
  let matrix: number[][] = Array.from({ length: m }, () => Array(n).fill(0));
  function dfs(row: number, col: number): number {
    if (row == m || col == n) return 0;
    if (row == m - 1 && col == n - 1) return 1;
    if (matrix[row][col] != 0) return matrix[row][col];
    let case0 = dfs(row, col + 1);
    let case1 = dfs(row + 1, col);
    matrix[row][col] = case0 + case1;
    return case0 + case1;
  }
  return dfs(0, 0);
}

// TC: O(mxn): SC: O(mxn)
function uniquePaths_tabulation(m: number, n: number): number {
  let matrix: number[][] = Array.from({ length: m }, () => Array(n).fill(0));

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (i == 0 || j == 0) {
        matrix[i][j] = 1;
      } else {
        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
      }
    }
  }
  return matrix[m - 1][n - 1];
}

describe("62. Unique Paths", () => {
  it("Basic - Memorisation", () => {
    expect(uniquePaths(3, 7)).toStrictEqual(28);
  });

  it("Basic - Tabulation", () => {
    expect(uniquePaths_tabulation(3, 7)).toStrictEqual(28);
  });
});
