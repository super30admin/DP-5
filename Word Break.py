# TC: O(N^3)
# SC: O(N)
# Yes, It ran on Leetcode
# No problems

class Solution:
    def wordBreak(self, s: str, wordDict) -> bool:
        
        DP = [False]*(len(s)+1)
        DP[0] = True
        
        for i in range(len(s)+1):
            if DP[i] == True:
                for j in range(i,len(s)):
                    if s[i:j+1] in wordDict:
                        DP[j+1] = True
        print(DP)
        return DP[-1]