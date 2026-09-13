# Problem1: (https://leetcode.com/problems/word-break/)
# Time Complexity: O(n^2),We have two nested loops over the string of length n and slicing s[j:i] can take up to O(n) more, so overall it is roughly O(n^3) in the worst case, but commonly stated as O(n^2) for the loop structure.
# Space Complexity: O(n),We store a dp array of size n+1, plus the set of words which takes extra space based on the dictionary.
# Approach:
# Use a boolean dp array where dp[i] means the first i characters of s can be segmented into dictionary words.
# dp[0] is True since an empty string needs no words.
# For each position i, check every earlier position j. If dp[j] is True and the substring from j to i is a dictionary word,
# then dp[i] is also True, since we can break s into a valid part before j plus this valid word.

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        set_ = set(wordDict)  # convert list to set for O(1) average lookup instead of O(n) list search
        n = len(s)  # length of the input string

        dp = [False] * (n + 1)  # dp[i] means s[0:i] can be segmented into dictionary words
        dp[0] = True  # empty prefix is always valid, base case

        for i in range(1, n + 1):  # i is the end of the prefix we are checking, from 1 to n
            for j in range(i):  # j is the split point, from 0 to i-1
                if dp[j] and s[j:i] in set_:  # prefix before j is valid, and the word from j to i is in the dictionary
                    dp[i] = True  # so the prefix up to i is also valid
                    break  # no need to check other split points once we found one that works

        return dp[n]  # whether the full string can be segmented