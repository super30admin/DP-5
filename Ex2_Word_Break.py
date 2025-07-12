# ----------------------------------------------------
# Intuition:
# Given a string s of length n and a dictionary of words, 
# determine if s can be segmented into a sequence of dictionary words.
#
# 1. Brute Force (Naive DFS):
#    Try every possible prefix substring starting at index 0.
#    If prefix is in dictionary, recursively check the rest of the string.
#    Explores all partition possibilities without caching results.
#    → Time: O(2^n), Space: O(n) recursion stack
#
# 2. Top-Down Memoization:
#    Same approach as brute force but cache results for each start index.
#    Prevents redundant work by returning previously computed answers.
#    → Time: O(n × k), Space: O(n) for memo + O(n) recursion stack
#
# 3. Bottom-Up DP (Tabulation) ✅
#    Use dp array of size n+1, where dp[i] means s[:i] can be segmented.
#    For each index i, check all j < i:
#      if dp[j] is True and substring s[j:i] (length ≤ k) in dictionary,
#      set dp[i] = True.
#    Builds solution iteratively from smaller substrings.
#    → Time: O(n × k), Space: O(n)
#
# Where:
# - n = length of the input string s
# - k = maximum length of any word in the dictionary (used for substring checks)
# ----------------------------------------------------

from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        word_set = set(wordDict)
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True  # base case: empty string

        for i in range(1, n + 1):
            for j in range(i):
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    break  # no need to check further splits

        return dp[n]

    # ----------------------------------------------------
    # 💬 Memoization (Top-Down DP)
    # ----------------------------------------------------
    # def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    #     word_set = set(wordDict)
    #     memo = {}

    #     def dfs(start):
    #         if start == len(s):
    #             return True
    #         if start in memo:
    #             return memo[start]

    #         for end in range(start + 1, len(s) + 1):
    #             if s[start:end] in word_set and dfs(end):
    #                 memo[start] = True
    #                 return True

    #         memo[start] = False
    #         return False

    #     return dfs(0)

    # ----------------------------------------------------
    # 💬 Brute Force (DFS without memo)
    # ----------------------------------------------------
    # def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    #     word_set = set(wordDict)

    #     def dfs(start):
    #         if start == len(s):
    #             return True

    #         for end in range(start + 1, len(s) + 1):
    #             if s[start:end] in word_set and dfs(end):
    #                 return True

    #         return False

    #     return dfs(0)


if __name__ == "__main__":
    sol = Solution()

    # Test Case 1
    s1 = "leetcode"
    wordDict1 = ["leet", "code"]
    print(f"Input: '{s1}', wordDict: {wordDict1} → Output:", sol.wordBreak(s1, wordDict1))  # True

    # Test Case 2
    s2 = "applepenapple"
    wordDict2 = ["apple", "pen"]
    print(f"Input: '{s2}', wordDict: {wordDict2} → Output:", sol.wordBreak(s2, wordDict2))  # True

    # Test Case 3
    s3 = "catsandog"
    wordDict3 = ["cats", "dog", "sand", "and", "cat"]
    print(f"Input: '{s3}', wordDict: {wordDict3} → Output:", sol.wordBreak(s3, wordDict3))  # False

    # Test Case 4 - edge
    s4 = ""
    wordDict4 = ["a"]
    print(f"Input: '{s4}', wordDict: {wordDict4} → Output:", sol.wordBreak(s4, wordDict4))  # True

    # Test Case 5
    s5 = "aaaaaaa"
    wordDict5 = ["aaaa", "aaa"]
    print(f"Input: '{s5}', wordDict: {wordDict5} → Output:", sol.wordBreak(s5, wordDict5))  # True

