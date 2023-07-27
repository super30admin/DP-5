#Time complexity is O(nl)
#Space omplexty is O(nl)
#No issues faced while coding
#COde ran successfully on leet code

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        #converting list into a set
        hset=set(wordDict)
        l=len(s)
        #Creating a dp array of size l+1
        dp=[False for i in range(l+1)]
        dp[0]=True
        #we will be iterating through each value in the dp array
        for i in range(1,len(dp)):
            for j in range(i):
                #We will be checking if dp[j] is true or not and s[j:i] is in the hset
                if(dp[j] and s[j:i] in hset):
                    #We will update dp[i] if it meets the above condition
                    dp[i]=True
        #We will be returning dp[l]
        return dp[l]

