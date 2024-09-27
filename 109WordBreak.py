"""
    brute force solution
"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hashSet =set(wordDict)
        dp = [False for i in range(len(s) + 1)]
        dp[0] = True
        for i in range(len(s) + 1):
            for j in range(i):
                if dp[j] and s[j:i] in hashSet:
                    dp[i] = True
                    break
        return dp[-1]

"""
    def __init__(self):
        hashSet = None

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.hashSet = set(wordDict)

        return self.helper(s)

    def helper(self,s):
        # base
        if len(s) == 0:
            return True
        # logic
        for i in range(1,len(s)+1):
            if s[0:i] in self.hashSet and self.helper(s[i:]) :
                return True
        return False
"""

        
