class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        # Decision Problem
        
        # Convert wordDict to a set for faster lookups
        word_set = set(wordDict)
        
        # Initialize DP table with False
        table = [False] * (len(s)+1)
        
        # Base Case - Empty String = True
        # table[0] = True
        
        for i in range(1, len(table)):
            table[i] = (s[:i] in word_set)
            if table[i] : print s[:i]
            for j in range(0, i):
                if s[i-j:i] in word_set and table[i-j] == True:
                    table[i] = True
                    print s[i-j:i]
        return table[-1]