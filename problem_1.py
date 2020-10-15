# 139. Word Break

# Code: 
# Approach: kindof similar to sliding window concept ( substring[j:i]) and make sure if its present in the dictionary or not.
# If its not present, keep incrementing the j (window) and keep checking.


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp = [False]*(len(s)+1)
        
        dp[0] = True
        
        for i in range(len(dp)):
            for j in range(0, i):
                # print(i, j, s[j:i])
                if dp[j] and (s[j:i] in wordDict):
                    # print("Present here : ", s[j:i])
                    dp[i] = True
                    break
        # print(dp)
        
        return dp[-1]

# Time Complexity: O(N^3)
# Space Complexity: O(N)
# Accepted on Leetcode: YES.