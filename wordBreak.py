# TC/SC: O(N**3)/ O(n)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s)+1)
        set_words = set(wordDict)
        
        dp[0] = True
        
        for i in range(1, len(s)+1):
            for j in range(i):
                if dp[j] and s[j:i] in set_words:
                    dp[i] = True
        
        return dp[-1]
            
        
