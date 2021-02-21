#Time complexity:O(n^3)
#Space Complexity:O(n)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if len(s)==0:
            return False
        dp=[False for i in range(len(s)+1)]             #a boolean array that holds the value of word present
        dp[0]=True
        for i in range(1,len(dp)):                      #using two pointer i and j we iterate through the string . 
            for j in range((i)):
                if dp[j] and s[j:i] in wordDict:        #if the string between i and j is present in the word list replace value with true
                    dp[i]=True
                    break
        return dp[-1]                                   #if return last value in dp array