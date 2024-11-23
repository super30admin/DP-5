#Time Complexity: O(n * m), where n is the length of the string s, and m is the total number of characters across all words in wordDict, as we iterate over the string and check substrings against all dictionary words.
#Space Complexity: O(n), as the dp array of size n + 1 is used.
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = []
        for i in range(len(s)+1):
            dp.append(False)
        dp[len(s)] = True
        for i in range(len(s)-1,-1,-1):
            for w in wordDict:
                if(len(w)<=len(s) and s[i:i+len(w)]==w):
                    dp[i]=dp[i+len(w)]
                if(dp[i]==True):
                    break
        return dp[0]
        