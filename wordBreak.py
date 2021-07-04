"""
Time Complexity : wordBreak_bruteForce_optimized - O(n^n)
                  wordBreak_dp - O(n^2)
Space Complexity : wordBreak_bruteForce_optimized - O(n)
                   wordBreak_dp - O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def wordBreak_bruteForce_optimized(self, s, wordDict):
        wordSet = set(wordDict)
        return self.helper(s, wordSet)
    
    def helper(self, s, wordSet):
        # base case
        if len(s) == 0:
            return True
        
        # logic
        for i in range(len(s)):
            if s[:i+1] in wordSet and self.helper(s[i+1:], wordSet):
                return True
        
        return False
    
    def wordBreak_dp(self, s, wordDict):
        wordSet = set(wordDict)   
        dp = [False]*(len(s) + 1)
        dp[0] = True
        
        for i in range(1, len(dp)):
            for j in range(i):
                if dp[j] == 1 and s[j:i] in wordSet:
                    dp[i] = 1
                    break
                    
        return dp[-1]
    
s = Solution()
print(s.wordBreak_dp("aaaaaaa", ["aaaa","aaa"]))