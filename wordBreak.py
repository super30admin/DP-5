# Approach : 1D DP
# algorithm:
# Start from the last location in the string s, iterate until the first index.
# while iterating, at each step iterate over the word dict, and if 
# (i+len(w)) <= len(s) and s[i:i+len(w)] == w then set dp[i] = dp[i+len(w)]
# initially dp[len(s)+1] will be True as the base case.
# TC: O(n^2) if we ignore the size of string slice and comparison else O(n^3)
# SC: O(n)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * len(s)
        dp.append(True)  # for base case
        
        for i in range(len(s) -1 , -1, -1):
            for w in wordDict:
                if (i+len(w)) <= len(s) and s[i:i+len(w)] == w:
                    # we need to do this dp[i+len(w)] because ther may be a possibility
                    # that when we find the word match, it may run over our previous word match
                    # e.g. "cars"
                    # ["car","ca","rs"]
                    # in above, at index 0 we find car but if we choose that word then
                    # we can't form entire word cars, as there's no `s` standalone in the dict
                    # meaning we can only use the current word if dp[i+len(w)] - meaning location
                    # of next word in the dp is True
                    # sample output showing what I mean :
                    # print of (dp, i, len(w), w)
                    # dp = [False, False, True, False, True] 2 2 rs
                    # dp = [True, False, True, False, True] 0 2 ca

                    dp[i] = dp[i+len(w)]
                    print(dp, i, len(w), w)
                if dp[i]:
                    break
        return dp[0]
            