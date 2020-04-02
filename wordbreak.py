# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
    
           
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        wordSet  = set()
        
        for word in wordDict:
            wordSet.add(word)
        
        s = '^'+ s
        valid = [False]*len(s)
        valid[0] = True
        
        for i in range(1,len(s)):
            
            k = i
            while k>=0:
                if s[k:i+1] in wordSet and valid[k-1]:
                    valid[i] = True
                    break
                k -=1
        
            
        return valid[len(s)-1]  
            
        
        