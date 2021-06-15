# TC: O(N ^ 2) since at every character we are checking substrings if that are present in the dictionary. 
# SC: O(N) where N is the length of the input string, the space used for the dp array. 

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False] * (len(s) + 1)
        dp[0] = True
        
        for i in range(1, len(s) + 1): 
            for j in range(0, i): 
                if dp[j] and s[j:i] in wordDict: 
                    dp[i] = True
                    break
        return dp[-1]
