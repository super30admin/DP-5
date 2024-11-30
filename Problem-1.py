class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        set_ = set(wordDict)
        n = len(s)
        dp = [False] * (n+1)
        dp[0] = True
        
        for i in range(n+1):
            for j in range(i):
                if(dp[j] and s[j:i] in set_):
                    dp[i] = True
                    break

        return dp[n]

        

        