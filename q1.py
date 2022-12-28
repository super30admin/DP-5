# Time Complexity : O(n*n), Where n is number of elements in the input string s
# Space Complexity : O(m+n), Where n is number of elements in the input string s and m is number of elements in the wordDict
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if(len(s)==0):
            return True
        hashset=set()
        for i in wordDict:
            hashset.add(i)
        n=len(s)
        dp=[ (True if(i==0)else False)for i in range(n+1)]
        #print(dp)
        for i in range(1,n+1):
            for j in range(0,i):
                if(dp[j]==False):
                    continue
                if(dp[j]==True):
                    #check for that remaining string is present in the hashset
                    if(s[j:i] in hashset):
                        dp[i]=True
                        break
                    else:
                        continue
        #print(dp)
        return dp[n]
            
            