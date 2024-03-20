'''
TC: O(n*n*m) - first 'n' - to go over the length of the string
                second 'n' - to create substrings each time
                m is to go through the wordDict
SC: O(n) - To create a dp boolean matrix
'''
from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False]*(len(s)+1)
        dp[-1] = True
        for i,num in reversed(list(enumerate(s))):
            for w in wordDict:
                if (i+len(w))<=len(s) and s[i:i+len(w)] == w:
                    dp[i] = dp[i+len(w)]
                if dp[i]:
                    break
        return dp[0]
s = Solution()
print(s.wordBreak("leetcode", ["leet","code"]))
print(s.wordBreak("applepenapple", ["apple","pen"]))
print(s.wordBreak("catsandog", ["cats","dog","sand","and","cat"]))
print(s.wordBreak("abcd", ["a","abc","b","cd"]))
print(s.wordBreak("cars", ["car","ca","rs"]))