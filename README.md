# DP-5

## Problem1: (https://leetcode.com/problems/word-break/)
# Time Complexity = O(n**3)
# Space Complexity = O(n)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        h=set(wordDict)
        dp=[0 for _ in range(len(s)+1)]
        for i in range(1,len(s)+1):
            curr=s[0:i]
            if curr in h:
                dp[i]=1
            else:
                for j in range(0,i):
                    if dp[j]==1 and s[j:i] in h:
                        dp[i]=1
                        break
        return dp[len(s)]==1
                        
                
## Problem2: (https://leetcode.com/problems/unique-paths/)
# Time Complexity = O(m+n)
# Space Complexity = O(n)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[]  
        for j in range(n):
            dp.append(1)
        for i in range(1,m):
            for j in range(1,n):
                dp[j]=dp[j]+dp[j-1]
        return dp[n-1]
        
        