"""
Approach:
- Use Dynamic Programming to check if the string can be segmented into words from the dictionary.
- Let dp[i] represent whether s[0:i] can be formed using words in wordDict.
- Initialize dp[0] = True (empty string is always valid).
- For each i in [1, len(s)], check all j in [0, i):
    - If dp[j] is True and s[j:i] is in wordDict, then set dp[i] = True.
- Final answer is dp[len(s)].

Time Complexity: O(n^2) where n = len(s) — nested loop
Space Complexity: O(n) for the dp array
"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordset = set(wordDict)
        dp = [False] * (len(s)+1)
        dp[0] = True
        for i in range(1, len(s)+1):
            for j in range(i):
                if dp[j] and s[j:i] in wordset:
                    dp[i] = True
                    break
        return dp[len(s)]

def main():
    sol = Solution()
    test_cases = [
        ("leetcode", ["leet", "code"], True),
        ("applepenapple", ["apple", "pen"], True),
        ("catsandog", ["cats", "dog", "sand", "and", "cat"], False),
        ("cars", ["car", "ca", "rs"], True),
        ("a", ["b"], False),
    ]

    for s, wordDict, expected in test_cases:
        result = sol.wordBreak(s, wordDict)
        print(f"s='{s}', wordDict={wordDict} => Output: {result} | Expected: {expected} | {'PASS' if result == expected else 'FAIL'}")


if __name__ == "__main__":
    main()
