// TC: O(2mxn) O(1)
function uniquePathsIII(grid: number[][]): number {
  const START = 1;
  const END = 2;
  const EMPTY = 0;
  const VISITED = 3;

  let totalEmptySlots = 0;
  let startRow = 0;
  let startCol = 0;

  for (let row = 0; row < grid.length; row++) {
    for (let col = 0; col < grid[row].length; col++) {
      if (grid[row][col] === EMPTY) totalEmptySlots++;
      if (grid[row][col] === START) {
        startRow = row;
        startCol = col;
      }
    }
  }

  const directions = [
    [-1, 0],
    [0, 1],
    [1, 0],
    [0, -1],
  ];

  let ways = 0;

  function traverse(
    row: number,
    col: number,
    slotsVisited: number,
    path: number[][]
  ) {
    if (grid[row][col] === END) {
      if (slotsVisited === totalEmptySlots + 1) {
        console.log("Reach End: " + path);
        ways++;
      }
      return;
    }

    if (grid[row][col] === EMPTY) {
      grid[row][col] = VISITED;
    }

    for (let dir = 0; dir < directions.length; dir++) {
      let [dx, dy] = directions[dir];
      let newRow = row + dx;
      let newCol = col + dy;
      if (
        newRow >= 0 &&
        newRow < grid.length &&
        newCol >= 0 &&
        newCol < grid[0].length &&
        (grid[newRow][newCol] === EMPTY || grid[newRow][newCol] === END)
      ) {
        traverse(newRow, newCol, slotsVisited + 1, [...path, [newRow, newCol]]);
      }
    }

    if (grid[row][col] === VISITED) {
      grid[row][col] = EMPTY;
    }
  }

  traverse(startRow, startCol, 0, [[startRow, startCol]]);
  return ways;
}


describe("980. Unique Paths III", () => {
  it.only("Basic", () => {
    expect(
      uniquePathsIII([
        [1, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 2, -1],
      ])
    ).toStrictEqual(2);
  });
});
