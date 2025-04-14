function wordBreak_tabulation(s: string, wordDict: string[]): boolean {
  let set: Set<string> = new Set(wordDict);

  let dp: boolean[] = Array.from({ length: s.length + 1 });
  dp.fill(false);
  dp[0] = true;

  for (let i = 1; i <= s.length; i++) {
    for (let j = 0; j < i; j++) {
      let subStr = s.substring(j, i);
      console.log("SubString: " + subStr + " From j: " + j + " To: " + i);
      console.log("DP: " + dp);
      if (dp[j] == true && set.has(subStr)) {
        dp[i] = true;
        console.log("DP: " + dp);
        break;
      }
    }
  }

  return dp[s.length];
}

function wordBreakII(s: string, wordDict: string[]): string[] {
  let set: Set<string> = new Set(wordDict);
  let words: string[] = [];
  function dfs(pivot: number, path: string[]) {
    if (pivot == s.length) {
      words.push(path.join(" "));
      return;
    }
    for (let index = pivot; index < s.length; index++) {
      let subStr = s.substring(pivot, index + 1);
      if (set.has(subStr)) {
        path.push(subStr);
        dfs(index + 1, path);
        path.pop();
      }
    }
  }
  dfs(0, []);

  return words;
}

function wordBreak(s: string, wordDict: string[]): boolean {
  let set: Set<string> = new Set(wordDict);
  function dfs(pivot: number): boolean {
    if (pivot == s.length) {
      return true;
    }
    for (let index = pivot; index < s.length; index++) {
      let subStr = s.substring(pivot, index + 1);
      if (set.has(subStr)) {
        return dfs(index + 1);
      }
    }
    return false;
  }
  let result = dfs(0);
  return result;
}

describe("139. Word Break", () => {
  it("Basic - Brute Force", () => {
    expect(wordBreak("leetcode", ["leet", "code"])).toStrictEqual(true);
  });

  it("Basic - Big Input", () => {
    expect(wordBreak("applepenapple", ["apple", "pen"])).toStrictEqual(true);
  });

  it("Basic - Negative", () => {
    expect(
      wordBreak("catsandog", ["cats", "dog", "sand", "and", "cat"])
    ).toStrictEqual(false);
  });

  it("Basic - Big Input - Tabulation", () => {
    expect(
      wordBreak_tabulation("applepenapple", ["apple", "pen"])
    ).toStrictEqual(true);
  });
});
