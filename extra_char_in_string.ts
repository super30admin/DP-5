function minExtraChar(s: string, dictionary: string[]): number {
  let set = new Set(dictionary);
  let dp: number[] = Array.from({ length: s.length });

  function dfs(pivot: number): number {
    if (pivot == s.length) {
      return 0;
    }
    if (dp[pivot] != null) return dp[pivot];
    let res = 1 + dfs(pivot + 1);
    for (let i = pivot; i < s.length; i++) {
      let substr = s.substring(pivot, i + 1);
      if (set.has(substr)) {
        res = Math.min(res, dfs(i + 1));
      }
    }
    dp[pivot] = res;
    return res;
  }
  return dfs(0);
}

describe("2707. Extra Characters in a String", () => {
  it("Basic - Brute Force", () => {
    expect(
      minExtraChar("leetscode", ["leet", "code", "leetcode"])
    ).toStrictEqual(1);
  });
});
