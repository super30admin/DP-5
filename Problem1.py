'''
Time Complexity: O(n^3) + O(m) where n is length of s and m is length of wordDict
Space Complexity: O(m) where m is length of wordDict
Run on Leetcode: YES
'''
class Solution:
    def wordBreak(self, s: str, wordDict: list[str]) -> bool:
        wordSet = set()
        for word in wordDict:
            wordSet.add(word)
        dp = [False] * (len(s) + 1)
        dp[0] = True
        for idx in range(1,len(dp)):
            for j in range(idx):
                if dp[j] and (s[j:idx] in wordSet):
                    dp[idx] = True
        return dp[-1]