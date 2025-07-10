# TC: O(ml + n^3)
# SC: O(ml + n)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hset=set(wordDict)
        dp=[False]*(len(s)+1)
        dp[0]=True
        for i in range(1,len(dp)):
            j=0
            while j<i:
                if dp[j]==True:
                    if s[j:i] in hset:
                        dp[i]=True
                        break
                j+=1

        return dp[-1]
