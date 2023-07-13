#Time Complexity:O(n^2)
#Space Complexity:O(n)

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        wordDict=set(wordDict)
        dp=[0]*(len(s)+1)
        dp[0]=True
        for i in range(1,len(s)+1):
            for j in range(i):
                if dp[j] and s[j:i] in wordDict:
                    dp[i]=True
                    break
        print(dp)
        return dp[len(dp)-1]