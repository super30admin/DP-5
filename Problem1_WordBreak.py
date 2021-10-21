# Time Complexity: O(n^3), where n - length of the string
# Space Complexity: O(n) + O(k), where k - number of words in wordDict

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s or len(s) == 0:
            return False

        # Boolean array to indicate if the word split until the previous index exists
        dp = [False for x in range(len(s) + 1)]
        dp[0] = True

        # Set to check the existence of the word
        words = set(wordDict)

        # Wherever there is a word split, check for the next word split from that point and mark True
        for i in range(1, len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in words:
                    dp[i] = True
                    break

        # Last value of the dp array would be True if s can be segmented completely
        return dp[-1]