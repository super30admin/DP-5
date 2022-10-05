class Solution:
    hashSet = {}

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s is None:
            return False

        # self.hashSet = {wordDict[i] for i in range(len(wordDict))}
        self.hashSet = set(wordDict)
        # n = len(s)
        return self.dfs(s, self.hashSet)

    def dfs(self, s, hashSet):
        # base case
        # print(s)
        if len(s) == 0:
            return True

        for i in range(len(s)):
            if s[0: i + 1] in self.hashSet and self.dfs(s[i + 1:], self.hashSet):
                return True

        return False
# Recursion Brute Force
# Time Complexity : O(2^n)
# Space Complexity : O(n). Size of the dp hashset
# Did this code successfully run on Leetcode : No, returned Time limit exceed
# Any problem you faced while coding this : No
