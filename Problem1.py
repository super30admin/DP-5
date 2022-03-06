# // Time Complexity : O(n^2) where n is length of the string s. 
# // Space Complexity : O(n) where n is length of the string s.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s)+1)
        set1 = set(wordDict)
        dp[0] = True
        for i in range(1,len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in set1:
                    dp[i] = True
        return dp[-1]
