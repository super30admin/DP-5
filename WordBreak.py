"""
The approach to this problem is to maintain a dp array, which stores T or F based on if the wordDict 
contains the sub-string till the current index, if so we can consider the sub-string till the current index
and at any given point if the other part of the main string i.e is the remaing part which has not been stored
in the dp array is found in the wordDict then we make the dp array of the currrent index to True, in this
way we check the entire string if it is present in the wordDict, if the last index of the dp array is True
then we can conclude that we found all the sub-strings in the wordDict.

Leetcode - Running
Time Complexity - O(N)
Space complexity - O(N)

"""


def wordBreak(self, s, wordDict):
    dp = [False] *(len(s)+1)
    dp[0] = True
    for i in range(len(s)):
        for j in range(i,len(s)):
            if dp[i] and s[i:j+1] in wordDict:
                dp[j+1] = True
    return dp[-1]