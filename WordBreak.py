# Time Complexity : O(n^3)
# Space Complexity : O(n)

from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s is None or len(s) == 0:
            return True
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True

        for i in range(1, n + 1):
            for j in range(i):
                if dp[j] and s[j:i] in wordDict:
                    dp[i] = True
                    break

        return dp[n]

# Examples
solution = Solution()

# Example 1
s1 = "leetcode"
wordDict1 = ["leet", "code"]
print("Word Break for '{}' with dictionary {}: {}".format(s1, wordDict1, solution.wordBreak(s1, wordDict1)))  # Output: True

# Example 2
s2 = "applepenapple"
wordDict2 = ["apple", "pen"]
print("Word Break for '{}' with dictionary {}: {}".format(s2, wordDict2, solution.wordBreak(s2, wordDict2)))  # Output: True

# Example 3
s3 = "catsandog"
wordDict3 = ["cats", "dog", "sand", "and", "cat"]
print("Word Break for '{}' with dictionary {}: {}".format(s3, wordDict3, solution.wordBreak(s3, wordDict3)))  # Output: False