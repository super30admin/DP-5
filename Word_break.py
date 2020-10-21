# Time - O(Npow3)
# Space - O(N)
# using dp and 2 pointers

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        if s == None or len(s) == 0:
            return 1
        
        hashset = set(wordDict)
        
        dp = [False]*(len(s)+1)
        dp[0] = True
        
        for i in range(len(s)):
            for j in range(i, len(s)):
                if dp[i] and s[i:j+1] in hashset:
                    dp[j+1] = True
        
        return dp[-1]
