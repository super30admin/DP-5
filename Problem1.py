"""
// Time Complexity : o(n^2 * L), L- avg length of word in dictionary
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        hash_set = set(wordDict) #create hashset of dictionary for easy access
        
        dp = [False] * (len(s) + 1) #create a boolean list
        dp[0] = True #set first index to true, meaning string before it is a valid partition(here "")
        
        for i in range(len(dp)):
            for j in range(i):
                
                if dp[j] == True and s[j:i] in hash_set: #checking to find a valid partition between j and i when substring before j is valid
                    dp[i] = True #if substring found in the hashset, set it true and break
                    break
                    
        return dp[-1] 
                
        