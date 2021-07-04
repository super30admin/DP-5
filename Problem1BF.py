# Time Complexity : O(2^N) (Where N is length of String)
# Space Complexity : O(N) 
# Did this code successfully run on Leetcode : No
# Three line explanation of solution in plain english:
# Brute force solution:
# - Start with fisrt character and make substring by increasing its size. 
# - If substring is found in wordDict do the same process for remaining substring.
# - If we reach to end without finding substring that exists in wordDict backtrack from there. After all this If we don't find solution return False.

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.wordDict = wordDict
        return self.helper(s, 0)
    
    def helper(self, s, left):
#       If start point reach to the end without any problem that means all substring exist in the dictionary so return true.
        if left == len(s):
            return True
#       Move right part of substring window till end of string.
        for right in range(left+1, len(s) + 1):
            # print(s[left:right+1])
#           If substring is found in the wordDict than call helper function on remaining substring
            if s[left:right+1] in self.wordDict and self.helper(s, right + 1):
#               If both this case returns true than return true
                return True
#       In the end return false.
        return False
