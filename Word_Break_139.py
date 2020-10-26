# Time - O(N ^ 2)

# Space - O(N)
class Solution:
#     Algo
# We come up with creating a DP table
# We set its first location as true , empty string is True
# Just see the case where we can track the True values in-between the DP table and our problem is done !
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        if not s:
            return False
        
        dp = [False for i in range(len(s)+ 1)]
        dp[0] = True
        # wordDict = set(wordDict)
        
        for i in range(1,len(s)+1):
            for j in range(0,i):
                if dp[j] and s[j:i] in wordDict:
                    dp[i] = True
                    break
        # print(dp)
        return dp[-1]
                