# Time Complexity : O(N^2) where N is the number of intervals
# Space Complexity : O(N) where N is the number of intervals
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using a recursive approach with memoization to solve the word break problem.
# I am storing the words in a hashset for O(1) lookup.
# I am using a helper function to check if the string can be segmented starting from a given pivot index.
# If the pivot index reaches the end of the string, I return True.
# If the pivot index has been previously computed and found to be False, I return False.
# I iterate through the string from the pivot index to the end, checking all possible substrings.
# If a substring is found in the hashset, I recursively call the helper function with the next index.
# If any recursive call returns True, I return True.

from typing import List
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hashset = set(wordDict)
        memo = [0] *len(s)
        def helper(pivot):
            if pivot == len(s):
                return True
            if memo[pivot] == 1:
                return False
            for i in range(pivot,len(s)):
                sub = s[pivot:i+1]
                if sub in hashset:
                    if helper(i+1):
                        return True
            memo[pivot] = 1
            return False
        return helper(0)


        
        