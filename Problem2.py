#Time Complexity :O(n^3)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        words=set(wordDict)
        dp=[False for i in range(len(s)+1)]
        dp[0]=True
        n=len(s)
        for i in range(0,n+1):
            for j in range(i):
                if dp[j] and s[j:i] in words:
                    dp[i]=True
        return dp[n]