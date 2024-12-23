# The wordBreak method checks if a string `s` can be segmented into a sequence of words from `wordDict`.

# Use DFS with memoization:
# - `dfs(i)` determines if the substring starting at index `i` can be segmented.
# - For each word in `wordDict`, check if it matches the current substring.
# - If a match is found, recursively check the remainder of the string.
# - Memoize the results to avoid redundant computations.

# Return True if the entire string can be segmented, otherwise False.

# TC: O(n * m) - n is the length of `s`, m is the average length of words in `wordDict`.
# SC: O(n) - Space for the memoization dictionary and recursion stack.


from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        memo = {len(s) : True}
        def dfs(i):
            if i in memo:
                return memo[i]
            
            for w in wordDict:
                if ((i + len(w)) <= len(s) and 
                     s[i : i + len(w)] == w
                ):
                    if dfs(i + len(w)):
                        memo[i] = True
                        return True
            memo[i] = False
            return False
        
        return dfs(0)