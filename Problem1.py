"""
TC: O(N squared) The time complexity is dominated by the nested loops. The outer loop runs N times, and the inner loop runs up to N times.
SC: O(N plus M) The space complexity is O(N) for the DP array and O(M) for the set conversion of the word dictionary.

Approach:

This problem is solved using Dynamic Programming (DP). The goal is to determine if the input string s can be segmented into a space-separated sequence of one or more dictionary words.

The dp array is defined such that dp[i] is a boolean value indicating whether the prefix of length i (s[0...i-1]) can be segmented.

1. Initialization: dp[0] is set to True because an empty string can always be segmented. The wordDict is converted to a set (s1) for efficient average time lookups.
2. DP Transition: We iterate through the string, and for each prefix ending at index i, we check all possible split points j. The prefix is segmentable (dp[i] is True) if a smaller prefix (dp[j]) is already segmentable AND the remaining suffix s[j:i] is a word in the dictionary set. Once a valid split is found, we break the inner loop.

The final answer is dp[-1], which indicates whether the entire string is segmentable.

The problem ran successfully on LeetCode.
"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False]*(len(s)+1)
        dp[0] = True
        s1 = set(wordDict)

        for i in range(1, len(s)+1):
            for j in range(0, i):
                if dp[j] and s[j:i] in s1:
                    dp[i] = True
                    break
        
        return dp[-1]

