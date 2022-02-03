#Space Complexity = O(n)
#Time Complexity = O(n)

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        l = len(s)
        dp = [False for _ in range(l+1)]
        worDict = set(wordDict)
        dp[0]=True
        for i in range(1,l+1):
            for j in range(0,i):
                if(dp[j]==True):
                    if(s[j:i] in worDict):
                        dp[i] = True
        print(dp)
        return dp[l]