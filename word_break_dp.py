# Time Complexity : O(N^3) where N is length of the string
# Space Complexity : O(N) recursion stack depth in the worst case where N is length of the string
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : No

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False for _ in range(len(s) + 1)]
        dp[0] = True
        wordsSet = set(wordDict)
        
        for i in range(len(dp)):
            for j in range(0, i):
                if dp[j] and s[j:i] in wordsSet:
                    dp[i] = True
                    break
        
        return dp[len(s)]