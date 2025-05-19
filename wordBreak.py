class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        """
        Approach:
        1. Use bottom-up dynamic programming (tabulation).
        2. dp[i] means whether the substring s[i:] can be segmented using words in wordDict.
        3. Initialize dp[len(s)] = True (base case: empty string is always valid).
        4. Traverse the string backwards and for each index i, check every word in wordDict:
           - If the substring s[i:i+len(w)] matches a word and dp[i+len(w)] is True,
             then set dp[i] = True.
           - Break early once dp[i] is True to avoid unnecessary checks.

        Time Complexity: O(n * m), where n = len(s) and m = average length of wordDict words.
        Space Complexity: O(n), for the dp array of size len(s) + 1.
        """
        dp = [False] * (len(s) + 1)
        
        # Base initialization
        dp[len(s)] = True 

        for i in range(len(s) - 1, -1, -1):
            for w in wordDict:
                if (i + len(w)) <= len(s) and s[i:i + len(w)] == w:
                    dp[i] = dp[i + len(w)]
                if dp[i]:
                    break
                    
        return dp[0]
