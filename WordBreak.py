"""
Time Complexity : O(n^4) where n is the length of my string s
Space Complexity : O(n) where n is the length of my string s
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if len(wordDict) == 0 and len(s) != 0:
            return False
        # Initialize a HashSet with all the words in the wordDict
        hashSet = set(wordDict)
        # Initialize the dp array with size one greater than the string to check the
        # matching words in the wordDict
        dp = [False] * (len(s) + 1)
        dp[0] = True
        # We traverse through the string and mark every indices at which we form a word
        # and whenever we find it we mark it True. While marking if the the last index
        # becomes True then s can be segmented to form words in wordDict so return True
        for i in range(len(s)+1):
            for j in range(i):
                if dp[j]:
                    if s[j:i] in hashSet:
                        dp[i] = True
                        break
        return dp[-1]