#https://leetcode.com/problems/word-break/discuss/164472/Python-solution
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        #O(n3)
        #O(n)
        wordSet = set(wordDict)
        dp = [0]*(len(s)+1)
        dp[0] = 1
        for i in range(1, len(s)+1):
            for j in range(i):
                if dp[j] == 1 and s[j:i] in wordSet:
                    dp[i] = 1
                    break
        return dp[-1] == 1
