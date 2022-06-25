class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s or len(s)==0:
            return True
        
        dp=[False for i in range(len(s)+1)]
        hashset=set(wordDict)
        dp[0]=True
        for i in range(len(dp)):
            for j in range(i):
                if dp[j]==True and s[j:i] in hashset:
                    dp[i]=True
                    break
                # else:
                #     dp[i]=False
        return dp[-1]
                
        
        