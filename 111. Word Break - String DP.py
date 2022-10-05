class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s is None:
            return False

        hashSet = set(wordDict)
        dp = [False] * (len(s) + 1)
        dp[0] = True

        for i in range(0, len(dp)):
            for j in range(0, i):
                # print(dp[j],s[i:j], i, j)
                if dp[j] and s[j:i] in hashSet:
                    dp[i] = True
                    break
        # print(dp)
        return dp[-1]

# String DP
# Time Complexity: O(n^2)
# Space Complexity: O(n). len of DP array
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
