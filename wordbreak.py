# Time Complexity : O(N^2) for each operation.
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use dp and check if previous partition are possible then make true.

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        d=set(wordDict)
        l=len(s)
        dp=[False]*(l+1)
        dp[0]=True
        for i in range(1, len(dp)):
            for j in range(0, i):
                if dp[j] and s[j:i] in d:
                    dp[i]=True
        return dp[l]