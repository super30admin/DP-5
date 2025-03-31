'''
    Time Complexity: O(n^2)
    Space Complexity: O(n)
'''
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        dp = [False for _ in range(n+1)]
        dp[0] = True
        wordDict = set(wordDict)

        for i in range(n+1):
            for j in range(i):
                if dp[j] == True:
                    if s[j:i] in wordDict:
                        dp[i] = True
                        break

        return dp[n]