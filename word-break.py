class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: Set[str]
        :rtype: bool
        """
        dp = [False for _ in range(len(s)+1)] 
        dp[0] = True
        # while i <len(s):
        #     if dp[i]:
        #         for j in range(i,len(s)):
        #             if s[i:j+1] in wordDict:
        #                 dp[j+1]=True
        #                 i=j
        #     else:
        #         i+=1
        # return dp[-1]
        for i in range(len(s)):
            if dp[i]:
                for j in range(i, len(s)):
                     if s[i: j+1] in wordDict:
                        dp[j+1] = True
                    
        return dp[-1]
                        