
# // Time Complexity : O(n^2)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :  Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 
#Brute Force would be finding every substring and checking if it exists in the wordDict. Worst case would be every substring is present in word dict hence it would take O((N^N)*N) time to find the solution.
#Optimal#1 would be to memoisation: store the answer (maybe in a hashmap) and then use it later again when we encounter the case. TC would be O(no. of valid partitions)

#DP: at every point, check if the previous substring is valid substring in Dict or not and move ahead. Mark True/1 if present and False/0 otherwise. Empty/nothing means valid partition. Now, in the second loop if dp[j] is True(there is a valid split in some way) and the s[j:i] substring is in the dictionary, we set dp[i] as True and return the last index as the answer. 

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        if s == None or len(s)==0:
            return True
        
        dp = [False]*(len(s)+1)
        hashset = set(wordDict)
        dp[0] = True
        
        for i in range(1, len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in hashset:
                    dp[i] = True
                    break
                    
        return dp[-1]