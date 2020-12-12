"""
TC=O(N^3) O(N)-->iteration for i and O(N) for j--i and O(N ) for substr
SC=O(N+1) -->dp table
"""


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if(s is None or len(s)==0):
            return False
        dp=[False]*(len(s)+1)
        dp[0]=True
        
        for i in range(len(dp)):
            for j in range(0,i):
                if(dp[j] and s[j:i] in wordDict):
                    dp[i]=True
                    break
        return dp[-1]
                    