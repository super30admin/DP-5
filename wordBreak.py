#Time Complexity: O(npowern)
#Space Complexity: O(N)
#Run on Leetcode: Yes
#Any Issues: No


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
         N = len(s)
    dp = [False]*N
    
    for i in range(N):
        if s[:i+1] in wordDict: 
            dp[i] = True
        else:
           for j in range(i):
               if dp[j] == True and s[j+1:i+1] in wordDict:
                   dp[i] = True
    
    return dp[-1]