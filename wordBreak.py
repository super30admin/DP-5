#Time complexity: O(2^n)
#Space complexity: O(2^n)

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.wSet = set(wordDict)

        return self.helper(s)
    def helper(self, s):
        if len(s) == 0:
            return True
        for i in range(len(s)):
            sub = s[:i+1]
            if sub in self.wSet and self.helper(s[i+1:]):
                return True
        return False
            
        
        
