#Space:O(n^n)
#time:O(n^n)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.set_wordDict = set(wordDict)
        self.memo = {}  
        
        def search(string_val):
            if not string_val:
                return True
            if string_val in self.memo:
                return self.memo[string_val]
            
            for j in range(1, len(string_val) + 1):
                if string_val[:j] in self.set_wordDict and search(string_val[j:]):
                    self.memo[string_val] = True
                    return True
            
            self.memo[string_val] = False
            return False
        
        return search(s)