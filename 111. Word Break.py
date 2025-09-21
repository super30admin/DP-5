class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # Creating a DP array where dp[i] is True if s[i:] can be segmented
        dp = [False] * (len(s) + 1)
        # Setting the base case: an empty string can always be segmented
        dp[len(s)] = True

        # Iterating backwards through the string
        for i in range(len(s) - 1, -1, -1):
            # Checking each word in the dictionary
            for w in wordDict:
                # Checking if the substring starting at i matches the word w
                if (i + len(w)) <= len(s) and s[i: i + len(w)] == w:
                    # Updating dp[i] if the remaining string can be segmented
                    dp[i] = dp[i + len(w)]
                # Breaking early if dp[i] is already True
                if dp[i]:
                    break

        # Returning whether the whole string can be segmented
        return dp[0]

# Time Complexity (TC): O(n * m * k), where n = len(s), m = number of words in wordDict, k = average length of words
# Space Complexity (SC): O(n), where n = len(s) for the dp array