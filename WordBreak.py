class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s)+1)
        dp[0] = True
        wordDict = set(wordDict)
        for i in range(len(s)+1):
            for j in range(i+1, -1, -1):
                if s[j:i] in wordDict and dp[j]:
                    dp[i] = True
                    
        return dp[-1]
Time: O(N^3)
Space: O(N)
