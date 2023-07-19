# Time Complexity : O(s^3)
# Space Complexity : O(s^2 + w*m) where s^2 is due to the cache, and w*m for for the wordSet which denotes total characters in the dictionary 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


from functools import cache
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)

        @cache
        def helper(curr):
            nonlocal wordSet
            if not len(curr):
                return True
            
            for i in range(len(curr)):
                subStr = curr[0:i+1]
                if subStr in wordSet:
                    if helper(curr[i+1:]):
                        return True
            return False

        return helper(s)