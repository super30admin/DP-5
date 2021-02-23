# -*- coding: utf-8 -*-
"""
TC:O(N^3) + where N is the number of words in the given list of dictionary, 2 nested loops + substring computation 
SC:O(N), length of number of words
"""

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if len(s) == 0:
            return True
        
        wordDict.sort()
        stack = [0]
        while len(stack) > 0:
            index = stack.pop(0)
            for word in wordDict:
                if (s[index:].startswith(word)):
                    newIndex = index + len(word)
                    if newIndex == len(s): 
                        return True
                    if newIndex not in stack:
                        stack.append(newIndex) 
        
        return False