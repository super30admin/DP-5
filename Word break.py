# Time Complexity: O(n^4)
# Space Complexity: O(n)
class Solution:
    def wordBreak(self, s, wordDict) :
        #     moving j ahead of i and checking if j is already true and that substring is present in dictionary then we will make taht index dp array as true we will not evaluate further
        # We will continue this doing on till we reaxh the end of the defined dp array

        n = len(s)
        dp = [0 for i in range(n + 1)]
        dp[0] = True

        for i in range(1, len(dp)):
            for j in range(i):

                if dp[j] and s[j:i] in wordDict:
                    dp[i] = True
                    break

        return dp[n]
