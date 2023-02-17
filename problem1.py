class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp=[False]*(len(s)+1)
        dp[0]=True
        wordDict=set(wordDict)
        for i in range(1,len(s)+1):
            for j in range(i):
                if s[j:i] in wordDict and dp[j]:
                    dp[i]=True
                    break
        return dp[-1]
                    
        