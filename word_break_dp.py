"""
Time Complexity : O(n^3) where n is the total number of characters in the s
                n: Looping through all characters in s
                n: Looping j through 1,2,3...n chacters will result in n
                n: Though finding in the hashset is O(1), in the end hashset will also loop through each character of the word, so it is n
Space Complexity : O(n*l) where n is the words in the dictionary and l is the average charcters in the word

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if len(s) == 0 or len(wordDict) == 0:
            return True
        hashset = set(wordDict)
        dp = [False] * (len(s)+1)
        dp[0] = True

        for i in range(len(dp)):
            for j in range(0, i):
                if dp[j] and s[j:i] in hashset:
                    dp[i] = True
                    break
        return dp[len(s)]
