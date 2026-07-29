## Problem1: (https://leetcode.com/problems/word-break/)
from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        """
        ========================================================================
        SOLUTION 1: Bottom-Up Dynamic Programming (Tabulation)
        ========================================================================
        
        Logic:
        - dp[i] represents whether the suffix substring s[i:] can be segmented 
          into valid dictionary words.
        - We build the answer backwards from index n down to 0 because index 'i' 
          depends on future subproblems (dp[j + 1]).
        
        Time Complexity: O(n^2 * k) or O(n^3) 
          - Outer loop runs n times (i from n-1 down to 0).
          - Inner loop runs up to n times (j from i to n-1).
          - String slicing s[i:j+1] takes up to O(n) time (where k is the average length of words).
          
        Space Complexity: O(n) + O(m)
          - O(n) for the `dp` array of size (n + 1).
          - O(m) space to store the set of dictionary words for O(1) average lookups.
        """
        words = set(wordDict)
        n = len(s)
        
        # dp[i] answers: "Can s[i:] be segmented into valid words?"
        dp = [False] * (n + 1)
        
        # Base Case: An empty suffix starting at index n is valid
        dp[n] = True
        
        # Iterate backwards from the end of the string to the beginning
        for idx in range(n - 1, -1, -1):
            for j in range(idx, n):
                # If prefix s[idx : j + 1] is valid AND the remaining suffix s[j + 1:] is valid
                if s[idx : j + 1] in words and dp[j + 1]:
                    dp[idx] = True
                    break  # Found a valid breakdown for s[idx:], no need to try longer prefixes

        # Return whether the full string s[0:] can be segmented
        return dp[0]


    
        """
        ========================================================================
        SOLUTION 2: Top-Down Recursion with Memoization
        ========================================================================
        
        Logic:
        - helper(idx) checks if the suffix starting at index `idx` can be broken down.
        - We use a dictionary `memo` to store previously evaluated subproblems (memo[idx]) 
          to avoid re-computing redundant branches (preventing exponential O(2^n) time).
        
        Time Complexity: O(n^2 * k) or O(n^3)
          - There are at most n distinct values for `idx`.
          - For each state, we loop up to n times and slice the string s[idx : j + 1].
          - Memoization guarantees each index state is solved only ONCE.
          
        Space Complexity: O(n) + O(m)
          - O(n) space for the `memo` hash map storing results for each index.
          - O(n) max call stack depth for the recursive function `helper`.
          - O(m) space for the set of words.
        """
        words = set(wordDict)
        n = len(s)
        memo = {}

        def helper(idx: int) -> bool:
            # Base Case: Reached the end of the string successfully
            if idx == n:
                return True
            
            # Return cached result if subproblem was already solved
            if idx in memo:
                return memo[idx]

            # Try every possible word/prefix starting at index `idx`
            for j in range(idx, n):
                prefix = s[idx : j + 1]
                if prefix in words:
                    # Recursively check if the remainder of the string from (j + 1) is valid
                    if helper(j + 1):
                        memo[idx] = True
                        return True

            # If no prefix split works from this index, cache False
            memo[idx] = False
            return False

        return helper(0)