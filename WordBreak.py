class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        """
        Solving using DP
        T: O(N^2)
        S: O(N)
        """
        if len(s) == 0 or s == '':
            return True
        
        dp = [False]*(len(s)+1)
        hash_set = set(wordDict)
        
        dp[0] = True
        
        for i in range(1, len(s)+1):
            for j in range(0, i):
                if dp[j] and s[j:i] in hash_set:
                    dp[i] = True
                    break
        return dp[-1]