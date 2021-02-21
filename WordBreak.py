# Time Complexity : O(N^3)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using DP as there are repeated subproblems. Initialize dp with length of string + 1
# dp[0] will be True
# Iterate i over the string and again iterate j until i
# Check if dp[j] is True and check if the substring from j upto i is in dictionary, if both the conditions are satisfied then set dp[i] to True and brea
# Return last element in dp array


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s:
            return False

        dp = [False for i in range(len(s) + 1)]

        dp[0] = True

        for i in range(len(s) + 1):
            for j in range(i):
                if dp[j] == True and s[j:i] in wordDict:
                    dp[i] = True
                    break
        return dp[-1]