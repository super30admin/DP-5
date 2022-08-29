# DP Solution
# Time Compelxity = O(n^4)
# Space Complexity = O(n)


class Solution:
    def wordBreak(self, s: str, wordDict: list[str]) -> bool:
        if s == None:
            return False
        
        hashSet = set(wordDict)
        
        n = len(s)
        dp = [False for j in range(n + 1)]
        dp[0] = True
        
        for i in range(1, n + 1):
            for j in range(i):
                if dp[j] == True:
                    if s[j:i] in hashSet:
                        dp[i] = True
                        break
                        
        return dp[n]           
            
        
        
        
        
'''       

# Exhaustive Approach(Brute Force) - Gives Time limit exceeded for extreme cases
# Time Complexity = O(2^n)
# Space Complexity = O(n)


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s == None:
            return False
        
        self.hashSet = set(wordDict)
        
        return self.helper(s, self.hashSet)
    
    def helper(self, s, hashSet):
        # Base Case
        if len(s) == 0:                # If reached the end of the string or no remainder string left
            return True
        
        # Logic
        # For loop based recursion
        for i in range (1, len(s) + 1):
            # If substring from 0 to i is in set and if it is present meanwhile call the remainder string using helper method. remainder starts from i
            if s[0:i] in self.hashSet and self.helper(s[i:], self.hashSet): 
                return True
            
        return False
        
'''