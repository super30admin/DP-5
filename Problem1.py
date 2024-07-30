#I used a dynamic programming approach. The goal is to determine if a given string s can be segmented into a space-separated sequence of one or more dictionary words from wordDict. First, I convert wordDict into a set for O(1) lookup times. I then initialize a boolean list dp of size n+1 (where n is the length of the string s) with all values set to False except for dp[0], which is True, representing the empty string. I iterate over each position i in s (from 1 to n). For each i, I check all possible substrings s[j:i] where j ranges from 0 to i-1. If dp[j] is True and s[j:i] is in the word set, I set dp[i] to True and break out of the inner loop as we found a valid segmentation ending at i. Finally, I return dp[n], which indicates whether the entire string can be segmented. The time complexity is O(n^2), as it involves two nested loops iterating over the string, and the space complexity is O(n) due to the additional storage for the dp array.

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        # Create set of words from list so that the lookup cost in dictionary becomes O(1)
        word_set = set(wordDict)

        # Initialize the lookup table
        dp = [False] * (n + 1)

        # Setting the first element to True as it represents the empty string
        dp[0] = True

        for i in range(1, n + 1):
            for j in range(i):
                # Checking if the substring from j to i is present in the wordDict and dp[j] is true
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    # If a substring is found, no need to check further smaller substrings
                    break

        # Return the last element of dp list
        return dp[n]