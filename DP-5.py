# DP-5

## Problem1: (https://leetcode.com/problems/word-break/)

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        words = set(wordDict)
      
        # Get the length of the string to process
        length_of_s = len(s)
      
        # Initialize a list where f[i] represents whether s[:i] can be segmented into words in the dictionary
        can_break = [True] + [False] * length_of_s
      
        # Iterate over all the positions of the string
        for i in range(1, length_of_s + 1):
            # Determine if there is a j where s[:j] can be segmented and s[j:i] is in the dictionary
            can_break[i] = any(can_break[j] and s[j:i] in words for j in range(i))
      
        # Return the value for the whole string, whether it can be segmented or not
        return can_break[length_of_s]
# TC = O(n^2 * k) where k is the maximum length of the word, SC = O(n + m)

## Problem2: (https://leetcode.com/problems/unique-paths/)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        path_counts = [1] * n      
        for row in range(1, m):
            for col in range(1, n):
                path_counts[col] += path_counts[col - 1]
        return path_counts[-1]
# TC =O( m * n), SC = O(n)
