"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(n*l+l^3)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


"""

# Word Breaks

# Approach - 1
# Recursion

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        hset=set(wordDict)
        return self.helper(s,hset)
    def helper(self,curr,hset):
        # base
        if len(curr)==0:
            return True

        # logic
        for i in range(len(curr)):
            substr=curr[0:i+1]
            if substr in hset and self.helper(curr[i+1:],hset):
                return True
        return False
    

# Approach - 2
# DP 
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        hset=set(wordDict)
        l=len(s)
        dp=[False for _ in range(l+1)]
        dp[0]=True
        for i in range(l+1):
            for j in range(0,i):
                if dp[j] and s[j:i] in hset:
                    dp[i]=True
        return dp[l]