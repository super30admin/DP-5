"""
Given a string s and a dictionary of strings wordDict, 
return true if s can be segmented into a space-separated sequence 
of one or more dictionary words.

Note that the same word in the dictionary may be reused 
multiple times in the segmentation.


"""

# Time Complexity : O(n^3)
# Space Complexity : O(n)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        # null case
        if s is None or len(s) == 0:
            return True
    
        wSet = set()
        wSet.update(wordDict)
        
        dp = [False]* (len(s) + 1)
        dp[0] = True
        
        #logic
        for i in range(1, len(s)+1):
            for j in range(0, i):
                if dp[j] == True and s[j:i] in wSet:
                    dp[i] = True
                    
                    
        return dp[-1]
                
        