# Recursion
# TC: O(n**n)
# We iterate through length of string- we append each char and check if it is there in the dict- if it is there- we try to partition the rest of the string recursively.
class Solution:
    hashset = None
    def wordBreak(self, s, wordDict):
        if not s : return False
        self.hashset = wordDict
        return self.helper(s)
    
    def helper(self, s):
        # base
        if len(s) == 0: return True    
        # logic
        for i in range(len(s)):
            if s[:i+1] in self.hashset and self.helper(s[i+1:]):
                return True
        return False


#TC: O(n3)
#SC: O(n)
#Subproblem: at each cell- we evaluate if string up until previous letter can be partitioned. 
class Solution:
    def wordBreak(self, s, wordDict):
        # edge
        if not s:
            return False
        n = len(s)
        dp = [None for i in range(n+1)]
        dp[0] = True
        for i in range(1,len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in wordDict:
                    dp[i] = True   
                    break
        return dp[-1]
        