'''
Dynamic Programming Approach
Accepted on leetcode(139)
time - O(N^2)
space - O(N)
'''


class Solution:
    def wordBreak(self, s: str, wordDict) -> bool:
        # Edge case
        if len(s) == 0:
            return True
        HashSet = set(wordDict)  # make a HashSet(O(1) search operation)
        # initialize Dp of size (length of given string + 1)
        dp = [False for i in range(len(s) + 1)]
        dp[0] = True

        # Iterate over all possible combinations by using recursion
        for i in range(1, len(dp)):
            for j in range(0, i):
                print(s[j:i])
                if s[j:i] in HashSet and dp[j]:
                    # above condition only passes when the word exists in the HashSet
                    dp[i] = True
        return dp[len(dp) - 1]