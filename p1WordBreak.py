"""
time: O(M*N)
space: O(N)
"""

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        """
        n = len(s)
        create dp array, not 2d, defaul False for n+1 for the extra calc
        
        """
        dp = [False] * (len(s) + 1)
        dp[len(s)] = True
        
        #iterate string starting from end to 0
        for i in range(len(s), -1, -1):
            for w in wordDict:
                #check if space in s which (i), has room for wordDict w
                if (i + len(w)) <= len(s) and s[i:i+len(w)] == w:
                    dp[i]=  dp[i+len(w)]
                if dp[i] :
                    break;
        return dp[0]
                