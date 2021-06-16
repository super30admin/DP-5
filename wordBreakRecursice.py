class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not wordDict:
            return None
        
        dataStore = set(wordDict)
        return self.helper(s, dataStore)
    
    def helper(self, s, dataStore):
        #base
        if len(s)==0:
            return True
        
        #logic
        for i in range(len(s)):
            if s[0:i+1] in dataStore and self.helper(s[i+1:],dataStore):
                print(s[0:i+1])
                return True
            
        return False
    
    #time complexity is n!
        
