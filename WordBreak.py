# Time Complexity : O(n^3)

# Space Compexity : O(nk)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s == None or len(s) == 0 or len(wordDict) == 0:
            return False
        set1= set(wordDict)
        n = len(s)
        dp = [0]* (n+1)
        dp[0] = True
        for i in range(1, n+1):
            for j in range(0, i):
                if dp[j] == True:
                    if s[j:i] in set1:
                        dp[i] = True
                        break
                else:
                    dp[i] = False
        return dp[n]

        