# Time Complexity : O(n^n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : Thinking about the logic and optimal solution

class Solution:
    def __helper(self, s, lookup_dict, i):
        if i == len(s):
            return True
        for j in range(i+1, len(s)+1):
            if s[i:j] in lookup_dict:
                if self.__helper(s, lookup_dict, j):
                    return True
        return False
    
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        return self.__helper(s, set(wordDict), 0)