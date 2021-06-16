class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        word_map = collections.defaultdict(int)
        for word in wordDict:
            word_map[word] += 1

        def helper(s):

            if len(s) == 0: return True

            # logic
            for idx in range(len(s)):

                if s[0:idx + 1] in word_map.keys() and helper(s[idx + 1:]):
                    print(s[0:idx + 1])
                    return True

            return False

        return helper(s)

TC:- O(n ^2) compare both numbers
Space:- O(N)

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        word_map = collections.defaultdict(int)
        for word in wordDict:
            word_map[word] += 1
        dp = [False] * (len(s) + 1)
        dp[0] = True

        for id in range(1, len(s) + 1):
            for j in range(id):
                if dp[j] and s[j:id] in word_map.keys():
                    dp[id] = True
                    break

        return dp[len(dp) - 1]
