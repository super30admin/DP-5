# T = O(n^3)
# S =O(n)

# Approach:
# Iterate through the array and maintain a dp array which will hold boolean value if there exists a valid word 
# that is the dictionary. Build the dp array aftere every addition of letter. THe last value of the dp array
# is the final Flag if a wors can be split or not.


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        i = 0
        j = 0
        dp = [False] * (len(s) + 1)
        dp[0] = True
        
        for i in range(1,len(s)+1):
            for j in range(i):
                if dp[j] and s[j:i] in wordDict:
                    dp[i] = True
                    break
        return dp[-1]
                    