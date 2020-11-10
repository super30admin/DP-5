"""
Name: Srinidhi Bhat
Did it run on LC: Yes

Time Complexity: O(N^2) - Recursion Tree - worst case when every prefix is a dictionary word - N^2 comparission
Space Complexity: O(len(wordDict)) - Additional Space for memo-Number of keys is words in wordDict
                                   - Extra space for Implicit Stack - O(n) - Number of words

Logic: 
check for each start,end combination if the word exists in the wordDict, if it does, the remaining part 
of it should also exist
else, return False, as it is not possible to make this combination

Memoise the Status - For each start to end combination, check if a word in wordDict is possible
with this memoisation, there is no need to compute repeatadly
"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        def wordBreakHelper(s,wordDict,start,end,memo):
            if s[start:end+1] in memo:
                return memo[s[start:end+1]]
            
            elif s[start:end+1] in wordDict:
                memo[s[start:end+1]] = True
                return True
            
            for i in range(start,end):
                if s[start:i+1] in wordDict and wordBreakHelper(s,wordDict,i+1,end,memo):
                    return True
            memo[s[start:end+1]] = False
            return False
            
        
        wordDict = set(wordDict)
        start,end = 0, len(s)-1 
        memo = {}
        
        return wordBreakHelper(s,wordDict,start,end,memo)