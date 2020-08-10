# Time Complexity :O(n^2)
# Space Complexity :O(n) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        # create a set of all words in dic
        myset = set(wordDict)
        m = len(s)
        # create a DP array of all false except first place as we know that nothing is part of set
        dp = [False]*(m+1)
        dp[0] = True
        # loop through s
        for i in range(1,m+1):
            #loop from back to i
            for j in range(i):
                # if at position j this was an end of a word try seeing if from this place to the ith place is a word or not if yes change to true and go to bigger loop
                if dp[j]:
                    if (s[j:i]) in myset:
                        dp[i] = True
                        break
        # see if all string can be words
        return dp[-1]