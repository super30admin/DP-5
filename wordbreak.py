"""
Iterate through the string and at each step check if the substring formed until now is in dictionary, 
TC: O(n*n*l) n- length of string, l length of dict
Sp: O(l) lenght of dict
"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hset = set(wordDict)
        dp = [False]*(len(s)+1)
        dp[0] = True
        for i in range(1,len(s)+1):
            for j in range(i):
                if dp[j] and s[j:i] in hset:
                    dp[i] = True

                    break
        return dp[-1]
