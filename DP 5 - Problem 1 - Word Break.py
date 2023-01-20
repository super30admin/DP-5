"""
FAANMG Problem #111 {Medium} 

139. Word Break


# Time : O(n^4) --> n^2 for traversing, n for subtring and n for checking in set
# Space : O(max(wordDict, dp))

Did this code successfully run on Leetcode : Yes

Sliding window


@name: Rahul Govindkumar
""" 

class Solution:
    

            
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # converting wordDict into a HashSet
        hashset=set(wordDict)
        
        # make a dp array of size len(s) + 1
        n = len(s)
        dp =[False]*(n + 1)
        
        dp[0] = True
        
        # Using two pointers technique
        # i is moving ahead
        for i in range(1,len(dp)):
            # we always point j starting from 0 till i
            
            for j in range(i):
                # make a substring from j to i
                substr= s[j:i]
                
                # check if the val at j index is True and also if the substring is present in the set
                # only then set the current i th index as True
                if( dp[j] and substr in hashset):
                    dp[i] = True
                    break
            
        
        return dp[n]
        