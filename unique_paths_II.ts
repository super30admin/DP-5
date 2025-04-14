function uniquePathsWithObstacles(obstacleGrid: number[][]): number {
  let matrix: number[][] = Array.from({ length: obstacleGrid.length }, () =>
    Array(obstacleGrid[0].length)
  );
  function dfs(row: number, col: number): number {
    if (
      row < 0 ||
      row >= obstacleGrid.length ||
      col < 0 ||
      col >= obstacleGrid[row].length
    ) {
      return 0;
    }
    if (obstacleGrid[row][col] == 1) {
      return 0;
    }
    if (row == obstacleGrid.length - 1 && col == obstacleGrid[row].length - 1) {
      return 1;
    }

    if (matrix[row][col] != null) return matrix[row][col];

    let case0 = dfs(row, col + 1);
    let case1 = dfs(row + 1, col);
    matrix[row][col] = case0 + case1;
    return case0 + case1;
  }
  return dfs(0, 0);
}

function uniquePathsWithObstacles_tabulation(obstacleGrid: number[][]): number {
  let matrix: number[][] = Array.from({ length: obstacleGrid.length }, () =>
    Array(obstacleGrid[0].length)
  );

  for (let row = 0; row < obstacleGrid.length; row++) {
    for (let col = 0; col < obstacleGrid[row].length; col++) {
      if (obstacleGrid[row][col] == 1) {
        // If there's an obstacle, set paths to 0
        matrix[row][col] = 0;
      } else if (row == 0 && col == 0) {
        // Start point
        matrix[row][col] = 1;
      } else if (row == 0) {
        // First row: can only come from the left if there's no obstacle
        matrix[row][col] = matrix[row][col - 1];
      } else if (col == 0) {
        // First column: can only come from above if there's no obstacle
        matrix[row][col] = matrix[row - 1][col];
      } else {
        // Sum of paths from the left and top cells
        matrix[row][col] = matrix[row - 1][col] + matrix[row][col - 1];
      }
    }
  }
  return matrix[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
}

describe("63. Unique Paths II", () => {
  it("Basic", () => {
    expect(
      uniquePathsWithObstacles([
        [0, 0, 0],
        [0, 1, 0],
        [0, 0, 0],
      ])
    ).toStrictEqual(2);
  });

  it("Basic - Tabulation", () => {
    expect(
      uniquePathsWithObstacles_tabulation([
        [0, 0, 0],
        [0, 1, 0],
        [0, 0, 0],
      ])
    ).toStrictEqual(2);
  });

  it("Edge Case", () => {
    expect(uniquePathsWithObstacles([[0, 0]])).toStrictEqual(1);
  });

  it("Edge Case 2", () => {
    expect(uniquePathsWithObstacles([[1, 0]])).toStrictEqual(0);
  });

  it.only("Edge Case 2 - Tabulation ", () => {
    expect(uniquePathsWithObstacles_tabulation([[1, 0]])).toStrictEqual(0);
  });
});
