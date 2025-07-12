# S30 Problem #111 Word Break
#LeetCode #139. https://leetcode.com/problems/word-break/description/

# Author : Akaash Trivedi
# Memorization
# Time Complexity O(n^3) 
# n for putting in set
# n^2 for recursion/for loops + n for getting substring = n^3
# Space Complexity : O(n)
# Did this code successfully run on Leetcode :  Yes #
# Any problem you faced while coding this : No

# brute force without pivot - gives TLE
# Time Complexity : O(2^n)
# check each substring is in wordSet and do it recursively
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)
        return self.helper(s, wordSet)

    def helper(self, s, wordSet) -> bool:
        # base
        if len(s) == 0: return True
        # logic
        for i in range(len(s)):
            # recursively call helper so that the rest of the string can be split into valid strings
            if s[0:i+1] in wordSet and self.helper(s[i+1:], wordSet):
                # if can be split into valid dict word
                return True
        return False 

# memorization 
# check each substring is in wordSet and do it recursively, if yes return True
# store the result in memorization
class Solution:
    def __init__(self):
        self.memo = {} # hashmap of memorization
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)
        return self.helper(s, wordSet)

    def helper(self, s, wordSet) -> bool:
        # base
        if len(s) == 0: return True
        # memorization
        if s in self.memo:
            return self.memo[s]
        # logic
        for i in range(len(s)):
            # recursively call helper so that the rest of the string can be split into valid strings
            if s[0:i+1] in wordSet and self.helper(s[i+1:], wordSet):
                # if can be split into valid dict word
                # store the result in memo
                self.memo[s] = True
                return True
        self.memo[s] = False
        return False     

# DP tabulation
# Can we split the string before, be split into valid splits substring 
# Use j to track the string before i (pivot) can be split into valid splits
# (dp[j] tells us if s[0:j] can be split into valid words)
# check if substring j to i is in hashset
# (s[j:i] in wordSet verifies the current segment is a valid word)
# as we find the valid split we can skip the traversal of j
# (break optimizes by stopping once we find any valid split for position)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict)
        dp = [False] * (len(s)+1)
        dp[0] = True # consider initial string before s (""s) as True
        # for rest of the dp
        for i in range(1,len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in wordSet:
                    dp[i] = True
                    break
        return dp[-1]

