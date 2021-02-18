class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        '''
        Bottom Up Approach
        Time: O(n^3)
        Space: O(n)
        '''
        x = set(wordDict)
        dp = [False for i in range(0,len(s))]
        # iterate over case where s = "leetcode"
        for i in range(0,len(s)):
            for j in range(0,i+1):
                if(j>0):
                    # check if leet is true
                    if(dp[j-1]==True):
                        # if yes, check code is in x
                        if(s[j:i+1] in x):
                            dp[i] = True
                            break
                else:
                    # this is mainly require to check for j=0, we need not to check dp[j-1] is true
                    if(s[j:i+1] in x):
                        dp[i] = True
                        break
        
        return dp[-1]
