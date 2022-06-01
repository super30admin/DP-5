#Word Break

# // Time Complexity :  O(N^3)+M
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp=[False for i in range(len(s)+1)]
        dp[0]=True
        words=set()
        for i in wordDict:
            words.add(i)                    #add the words to a set
        for i in range(1, len(s)+1):
            for j in range(i):
                if(dp[j]):                  # if the array is True, then you know everything to the left subarray exists, so check the right side up to i if they exist
                    sub = s[j:i]           
                    if(sub in words):       #if the right subarray exists, then set the i index to trueß
                        dp[i]=True
                        break
        return dp[-1]



ßß
    