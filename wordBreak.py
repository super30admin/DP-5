# Time Complexity : O(n^2)
# Space Complexity : O(n)

#Recursive Approach

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hashset = None

    def wordBreak(self, s, wordDict):
        if not s: return False
        self.hashset = wordDict
        return self.helper(s)

    def helper(self, s):
        # base
        if len(s) == 0: return True
        # logic
        for i in range(len(s)):
            if s[:i + 1] in self.hashset and self.helper(s[i + 1:]):
                return True
        return False

# Time Complexity : O(n^3)
# Space Complexity : O(n)

# At each cell we evaluate if string up until previous letter can be partitioned

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # edge
        if not s:
            return False
        n = len(s)
        dp = [None for i in range(n + 1)]
        dp[0] = True
        for i in range(1, len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in wordDict:
                    dp[i] = True
                    break
        return dp[-1]