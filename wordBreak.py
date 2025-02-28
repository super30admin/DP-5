class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # T: O(n ** 3), S: O(n)
        # Convert wordDict to a set for O(1) lookups
        word_set = set(wordDict)

        # Create a DP array: dp[i] = True if s[0:i] can be segmented
        # Add +1 to handle the empty string case dp[0]
        dp = [False] * (len(s) + 1)

        # Empty string can always be segmented (base case)
        dp[0] = True

        # For each position in the string
        for i in range(1, len(s) + 1):
            # Try all possible last words that could end at position i
            for j in range(i):
                # If the substring s[0:j] can be segmented (dp[j] is True)
                # AND the substring s[j:i] is a dictionary word
                if dp[j] and s[j:i] in word_set:
                    # Then s[0:i] can be segmented
                    dp[i] = True
                    # Once we find a valid segmentation, no need to check more
                    break

        # Return whether the entire string can be segmented
        return dp[len(s)]
