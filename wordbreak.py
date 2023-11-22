# // Time Complexity :O(n^2)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we implemented two ways- using a top-down approach and a bottom-up approach. In the bottom up one - we iterate over the string and see if at each point the substring till the point before can be partitioned
# into valid substrings from worddict. if yes- we set it to True so that next tme we need to check only if its True since if its false - its meant we dnt have a valid partition till that point
class Solution(object):
    # def helper(self,s,hset):
    #     # base
    #     if(len(s)==0):
    #         return True
    #     # logic
    #     for i in range(len(s)):
    #         sub=s[:i+1]
    #         if(sub in hset) and self.helper(s[i+1:], hset):
    #             return True
    #     return False
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        # top-down
        # hset=set(wordDict)
        # return self.helper(s,hset)
        # bottom up
        hset=set(wordDict)
        n=len(s)
        dp=[False] * (n+1)
        dp[0]=True
        for i in range(1,n+1):
            for j in range(i):
                if(dp[j] and s[j:i] in hset):
                    dp[i]=True
                    break
                
        return dp[n]

        
