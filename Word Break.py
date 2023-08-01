# Time Complexity : O(n * l + l^3)
# Space Complexity : O(n) to maintain the dp array and O(len(wordDict)) for the hash set

# The code ran on Leetcode

# Iterate over the string and keep checking if the string upto that point can be partitioned using elements in the hash set

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        dp = [False]*(n+1)
        hash_set = set(wordDict)
        dp[0] = True # '' can be formed
        for i in range(1, n+1):
            for j in range(i):
                if dp[j] == True and s[j:i] in hash_set:
                    dp[i] = True
        print(dp)
        return dp[-1]