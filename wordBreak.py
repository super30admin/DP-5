# Time Complexity : O(N^3) n = length of string
# Space Complexity : O(N)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :


# Your code here along with comments explaining your approach

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s:
            return False
        
        seen = set()
        dp = [False] * (len(s)+1)
        
        dp[0] = True
        
        for word in wordDict:
            seen.add(word)
            
        for i in range(1, len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in seen:
                    dp[i] = True
                    break
        return dp[-1]
            