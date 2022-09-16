"""
Problem1: (https://leetcode.com/problems/word-break/)
"""

# Approach - 1

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        """
        Brute force with recursion
        Time Comlexity: O(2^n)
        Space complexity : O(n) n is the length of the string
        """

        def helper(s, wordlist):
            # Base Case
            if len(s) == 0: return True
            
            # Recurive case
            for i in range(len(s)):
                substr = s[0: i+1]
                
                if  substr in wordlist and helper(s[i + 1:], wordlist):
                    return True
                
            return False
        
        return helper(s, set(wordDict))
        

# Approach - 2

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        """
        for loop recursion with same time and sapce complexity
        """
        
        def helper(s, wordlist , idx):
            # Base Case
            if len(s) == idx : return True
            
            # Recurive case
            for i in range(idx, len(s)):
                substr = s[idx : i+1]
                if  substr in wordlist and helper(s, wordlist, i +1):
                    return True
                
            return False
        
        return helper(s, set(wordDict), 0)

# Approach - 3
        
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        """
        Brute force with recursion
        Time Comlexity: O(n^3)
        Space complexity : O(n) n is the length of the string
        """
        wordDict = set(wordDict)
        n = len(s)
        dp = [False for _ in range(n + 1)]
        dp[0] = True
        
        for i in range(len(dp)):
            for j in range(0, i):
                if dp[j] and s[j:i] in wordDict:
                    dp[i] = True
                    break
                    
        return dp[len(dp) - 1]
    
        
        