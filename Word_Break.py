#Space:O(n^n)
#time:O(n^n)
#results into TLE
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        self.set_wordDict = set(wordDict)
        self.ans = False
        
        def search(string_val):
            if not string_val:
                self.ans = True
                return
            for i in range(len(string_val)):
                for j in range(i,len(string_val)):
                    if string_val[:j+1] in self.set_wordDict:
                        search(string_val[j+1:])
        
        search(s)
        return self.ans