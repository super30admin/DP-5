class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        store=dict()
        for val in wordDict:
            store[val]=True
        dp=[False]*(len(s)+1)
        dp[0]=True
        for i in range(1,len(dp)):
            for j in range(0,i):
                v=s[j:i]
                if v in store and dp[j]:
                    dp[i]=True
        return dp[len(dp)-1]
        #Time O(n^3)
        #Space O(n)
