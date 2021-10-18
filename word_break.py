# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach





class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp=[0 for i in range(len(s)+1)]
        print(dp)
        dp[0]=1
        i=0
        for j in range(1,len(s)+1):
            for i in range(j):
                print(s[i:j])
                if dp[i]==1:
                    if s[i:j] in wordDict:
                        dp[j]=1
                        break
            print(dp)
        return dp[len(s)]==1
                    
            
        