class Solution:

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # using memoization- top down dp method
        self.word_Set = set(wordDict)
        return self.helper(s, 0)

    def helper(self, s, pivot):
        # base case
        if pivot == len(s):
            return True
        # logic
        for i in range(pivot, len(s)):
            substr = s[pivot : i + 1]

            if substr in self.word_Set and self.helper(s, i + 1):
                return True
        return False

    # time complexity is n^n
    # space complexity is O(n)

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True

        word_set = set(wordDict)
        for i in range(1, n + 1):
            for j in range(i):
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    break
        return dp[n]

    # time complexity is O(n^2)
    # space complexity is O(n+m)
