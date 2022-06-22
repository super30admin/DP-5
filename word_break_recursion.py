# Time Complexity : O(2 ^ N) where N is length of the string
# Space Complexity : O(N) recursion stack depth in the worst case where N is length of the string
# Did this code successfully run on Leetcode : No (Time Limit Exceeded)
# Any problem you faced while coding this : No

class Solution:
    def __init__(self):
        self.wordsSet = set()
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.wordsSet = set(wordDict)
        return self.breaker(s)
    
    def breaker(self, s):
        #base
        if len(s) == 0: return True
        
        #logic
        for i in range(len(s)):
            if s[:i+1] in self.wordsSet and self.breaker(s[i+1:]):
                return True
            
        return False