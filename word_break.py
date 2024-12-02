"""
Time: O(n)
Space: O(n)
Leet: Accepted
Problems: Had to refer Solution
"""
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        dp = [0] * (len(s)+1)
        dp[0] = 1

        #iterate over string
        for i in range(1,len(s)+1):
            #iterate over words
            for word in wordDict:
                word_length = len(word)
                #if current position - word_length forms a valid word
                #and if the valid word starts from a valid position
                if s[i-word_length:i] == word and dp[i-word_length] == 1:
                    #set position to true
                    dp[i] = 1
        return dp[-1]
