# Time complexity: O(n^4)
# Space complexity: O(n)
# Approach: Do dynamic programming
# put the dictionary list in hashset
# create a dp array of one size more than the string
# run a loop for i in range 0 to len(string)+1
# j runs from 0 to i
# check if dp[j] is true, check for string of j to i, if present in hashset, dp[i] becomes true and break
# if dp[j] if false no need to check string of j to i since string[0 to j] is not present in dict
# do this till the last index and return the last element in dp

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hashset = set(wordDict)
        n = len(s)
        dp = [False for i in range(n+1)]
        dp[0] = True
        for i in range(1,n+1):
            for j in range(0, i):
                if dp[j]:
                    if s[j:i] in hashset:
                        dp[i] = True
                        break
        return dp[i]
                        
        