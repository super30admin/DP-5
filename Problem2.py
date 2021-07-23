# Time Complexity : O(n**4)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# save output of first i characters and iterate form i to j to check if there's
# valid substring which is present in the dictionary
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s == None:
            return False
        
        dict = {}

        for i in wordDict:
            dict[i] = True
        m = len(s)
        dp = [False]*(m+1)
        dp[0] = True
        for i in range(1,len(dp)):
            for j in range(0,i):
                if dp[j] == True and s[j:i] in dict:
                    dp[i] = True
                    break
        
        return dp[len(dp)-1]
        
        