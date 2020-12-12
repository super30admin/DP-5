"""
Bruete Force solution Time limit exceeded

exponential time of len of string

"""


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.d=wordDict
        if(s is None or len(s)==0):
            return False
        self.d=wordDict
        return self.helper(s)
    
    
    def helper(self,s):
        #base
        if(len(s)==0):
            return True
        
        #logic
        for i in range(len(s)):
            if s[0:i+1] in self.d and self.helper(s[i+1:]):
                return True
        
        return False
                