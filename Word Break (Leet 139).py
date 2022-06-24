'''
Using DP
Time: O(n^3) ideally O(n^4)
Space: O(n)

we can also use tries for implementing this program insted of hashset
'''
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:

        hs = set(wordDict)

        dp = [False for x in range(len(s) + 1)]
        dp[0] = True

        for i in range(1, len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in hs:
                    dp[i] = True
                    break
        return dp[-1]

'''
Using brute force recursion
'''


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.hs = set(wordDict)

        return self.dfs(s)

    def dfs(self, s):
        if s == '':
            return True

        for i in range(len(s)):
            sub = s[0:i + 1]
            if sub in self.hs:
                if self.dfs(s[i + 1:]):
                    return True
        return False