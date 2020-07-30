# Time Complexity : O(n) [n = length of input string]
# Space Complexity : O(n + m * l ) [n = length of input string, m = length of wordDict , l = average length of string]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        s_len = len(s)
        memo = [False] * (s_len + 1)
        memo[0] = True
        wordDict = set(wordDict)
        for i in range(1, s_len+1):
            for j in range(i):
                if s[j:i] in wordDict and memo[j]:
                    memo[i] = True
                    break
        return memo[s_len]