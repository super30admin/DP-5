# Recursive Solution
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        def helper(s, hashset):
            
            # Base condition
            if len(s) == 0:
                return True
            # Main logic
            
            for i in range(1, len(s) + 1):
                if (s[0:i] in hashset and helper(s[i:], hashset)):
                    return True
                
            return False
        
        
        if len(s)== 0:
            return True
        
        if len(wordDict) == 0:
            return True
        
        hashset = set(wordDict)
        return helper(s, hashset)

# Dynamic Programming Solution
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        
        n = len(s) 
        dp = [False] * (n + 1)
        dp[0] = True
        
        hashset = set(wordDict)
        
        for i in range(n+1): #O(n)
            for j in range(n+1): #O(n)
                
                if dp[j]:
                    if s[j:i] in hashset: # O(n) time for getting the substring
                        dp[i] = True
        return dp[-1]
                    
        
        
        # Time Complexity: O(n^3)
        # Space Complexity: O(n)
                      
        