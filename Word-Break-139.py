# Time Complexity : O(n2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        
        wordSet = set(wordDict)
        m = len(s)
        if m == 0:
            return True
        dp = [False for _ in range(m + 1)]
        dp[0] = True
        
        for i in range(1, m + 1):
            for j in range(0, i):
            
                if dp[j] and s[j:i] in wordSet:
                    dp[i] = True
        
        
        return dp[m]
        