class Solution(object):
    class TrieNode(object):
        def __init__(self):
            self.children = {}
            self.isWord = False
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        #dp
        #time complexity: O(n^3)
        if s is None:
            return False
        wordSet = set(wordDict)
        dp = [False for x in xrange(len(s)+1)]
        dp[0] = True
        for i in xrange(1,len(dp)):
            for j in xrange(0,i):
                if dp[j] and s[j:i] in wordSet:
                    dp[i] = True
                    break
        return dp[-1]
        #brute force
        #time complexity: O(n^n)
        # if s is None:
        #     return False
        # wordSet = set(wordDict)
        # def helper(s,wordSet):
        #     #base
        #     if len(s) == 0:
        #         return True
        #     #logic
        #     for i in xrange(1,len(s)+1):
        #         if s[:i] in wordSet and helper(s[i:],wordSet):
        #             return True
        #     return False
        # return helper(s,wordSet)
        
