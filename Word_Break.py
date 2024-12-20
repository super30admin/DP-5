# Approach:
# The problem can be solved using dynamic programming. 
# We can use a boolean array dp where dp[i] represents whether the substring s[0...i-1] can be segmented into words from the dictionary.
# 1. Initialize dp[0] = True because an empty string can always be segmented.
# 2. Iterate through each position i in the string s. For each position, check all previous positions j where dp[j] is True.
#    If s[j...i] is a word in the dictionary, mark dp[i] as True.
# 3. The final result will be stored in dp[len(s)], which will tell if the entire string can be segmented.
# 4. Use a set for the wordDict to perform faster lookups.

# Time Complexity: O(n^2), where n is the length of the string s. We iterate over all pairs of indices.
# Space Complexity: O(n), where n is the length of the string s. We use a dp array of size n+1.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # Convert wordDict to a set for faster lookups
        word_set = set(wordDict)
        
        # Initialize a dp array of size len(s) + 1 with False values
        dp = [False] * (len(s) + 1)
        
        # Empty string can always be segmented
        dp[0] = True
        
        # Iterate over each index of the string s
        for i in range(1, len(s) + 1):
            # Check all previous positions j
            for j in range(i):
                # If dp[j] is True and s[j:i] is a valid word, set dp[i] to True
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    break
        
        # Return whether the entire string s can be segmented
        return dp[len(s)]
