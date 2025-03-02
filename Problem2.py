# This approach keeps a track of if the string can be formed up until the ith index
# by using a dp array. The time complexity is O(n^2) and the space complexity is O(n)
# Yes, this worked in leetcode

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s))
        for i in range(len(s)):
            for j in wordDict:
                if i < len(j) - 1:
                    continue
                if i == len(j) - 1 or dp[i - len(j)]:
                    if s[i - len(j) + 1: i + 1] == j:
                        dp[i] = True
                        break
        return dp[-1]