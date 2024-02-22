# Time Complexity :O(n^2 * m), where n is the length of the input string s and m is the average length of words in the dictionary.
# Space Complexity :O(n + m)
# Did this code successfully run on Leetcode :yes

from ast import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hash_set = set(wordDict)
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True

        for i in range(1, n + 1):
            for j in range(i):
                sub_str = s[j:i]
                if dp[j] and (sub_str in hash_set):
                    dp[i] = True
                    break

        return dp[n]
