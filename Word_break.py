# Sliding window
# Time : O(n^4) --> n^2 for traversing, n for subtring and n for checking in set
# Space : O(max(wordDict, dp))

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # converting wordDict into a HashSet
        words = set(wordDict)
        
        # make a dp array of size len(s) + 1
        dp = [False for _ in range(len(s)+1)]
        
        i = j = 0
        # make the first element as true
        dp[0] = True
        
        # Using two pointers technique
        # i is moving ahead
        for i in range(1,len(dp)):
            # we always point j starting from 0 till i
            for j in range(i):
                # make a substring from j to i
                subs = s[j:i]
                # check if the val at j index is True and also if the substring is present in the set
                # only then set the current i th index as True
                if dp[j] and subs in words:
                    dp[i] = True
        
        # return the value of the last index as the final answer
        return dp[len(s)]
