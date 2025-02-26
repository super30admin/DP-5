class Solution:
    # dp
    # TC:O(n**2)
    # SC: O(n+k)
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s is None or len(s) == 0 or len(wordDict) == 0:
            return False
        hset = set(wordDict)
        n = len(s)
        dp = [False]*(n+1)
        dp[0] = True
        for i in range(1,n+1):
            for j in range(0,i):
                if dp[j] == True:
                    if s[j:i] in hset:
                        dp[i] = True
                        break
        return dp[n]
        