"""
1. we check for each word in the dictionary, there exists a suffix of the s that matches the word
2. we maintain a dp array to let us know if that index is an ending index of a valid word break
3. Starting from end of string, we try to reach the start or go before the start of the string using word dicts words 

TC: O(n*m*k) where n is length of s, m is number of words in dict and k is max length of word 
SC: O(n) -> recursion stack space + memo array
"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        memo = [False] * len(s)

        @cache
        def dp(i):
            if i < 0:
                return True
            
            for word in wordDict:
                if s[i - len(word) + 1: i + 1] == word and dp(i - len(word)):
                    return True
                
            return False
        
        return dp(len(s) - 1)
        

