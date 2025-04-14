// TC: O(mxn): SC: O(mxn)
function maxSumAfterPartitioning(arr: number[], k: number): number {
  let n = arr.length;
  let dp: number[] = Array.from({ length: n });
  dp.fill(0);
  dp[0] = arr[0];

  for (let i = 1; i < n; i++) {
    let max = arr[i];
    for (let j = 1; j <= k && i - j + 1 >= 0; j++) {
      max = Math.max(max, arr[i - j + 1]);
      if (i - j >= 0) {
        dp[i] = Math.max(dp[i], max * j + dp[i - j]);
      } else {
        dp[i] = Math.max(dp[i], max * j);
      }
    }
  }
  return dp[n - 1];
}

describe("1043. Partition Array for Maximum Sum", () => {
  it("Basic", () => {
    expect(maxSumAfterPartitioning([1, 15, 7, 9, 2, 5, 10], 3)).toStrictEqual(
      84
    );
  });
});
