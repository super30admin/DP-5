class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        wordSet=set(wordDict)

        def helper(s,idx):
            if idx==len(s): 
                return True
            for i in range(idx,len(s)):
                sub=s[idx:i+1]

                if sub in wordSet and helper(s,i+1):
                    return True
            return False

        return helper(s,0)
