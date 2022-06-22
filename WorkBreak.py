#Time complexity: O(l^3)
#Space complexity: O(l)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        st=set(wordDict)
        dp=[False]*(len(s)+1)
        dp[0]=True
        for i in range(1,len(s)+1):
            for j in range(0,i):
                if dp[j]== True and s[j:i] in st:
                    dp[i]=True
        return dp[-1]
        