# Problem 1 : Word Break
# Time Complexity : 
'''
Bottom-up: O(n^2) where n is the length of the string
Memoization: O(n^2) where n is the length of the string
'''
# Space Complexity : 
'''
Bottom-up: O(n+m) where n is the length of the string and m is the number of wordDict
Memoization: O(n+m) where n is the length of the string and m is the number of wordDict
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # creatig a hash set for wordDict list
        hashSet = set(wordDict)
        # get the length of the string s
        n = len(s)
        # initialize the dp matrix with size n+1 with value False
        dp = [False] * (n+1)
        # set the value of dp[0] as True
        dp[0] = True
        # loop through string from 1st character to last
        for i in range(1, len(dp)):
            # loop from value 0 to i
            for j in range(0, i):
                # check if the dp[j] as True and sub string from j to i position is in hashSet
                if dp[j] == True and s[j:i] in hashSet:
                    # if both condition is true then set the dp[i] as True and break from the loop
                    dp[i] = True
                    break
        # finally return the value of dp[n]
        return dp[n]
    
# Memoization
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # creatig a hash set for wordDict list
        hashSet = set(wordDict)
        # creating a hash set for memoization ie for storing the result
        memo = set()

        # helper function to check if the substring is in the wordDict or not
        def helper(s: str, hashSet: List[str], memo: List[str]) -> bool:
            # if the length of the string s is 0 then return True
            if len(s) == 0: return True
            # if there is a value in memo hash set then return False
            if s in memo: return False
            # loop through the string s
            for i in range(0,len(s)):
                # get the substring from 0 to i+1 of the string s
                sb = s[0:i+1]
                # check if the sub string is in hash set
                if sb in hashSet:
                    # if it is then get the rest of the sub string 
                    rest = s[i+1:]
                    # call helper function on that sub string
                    result = helper(rest, hashSet, memo)
                    # if the result is true then return true
                    if result: return True
                    # and if it is false then add the sub string in the memoization, ie. memoization will store the substring which are not in wordDict
                    else: memo.add(rest)
            # finally return False if the sub string is not matching wordDict
            return False
        # call helper function for complete string
        return helper(s, hashSet, memo)