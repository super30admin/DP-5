#TC:O(n)
#SC:O(1)
#Ran successfully on Leetcode:yes
#Algo:
#1.Create a boolean dp array 
#2.Set its first loc as true
#3.Iterate thru the word till its from 0-ith length and check if it exists in the dictionary given. 
#4.If yes set that loc in dp arr true else break.
#5.Return dp[-1]

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        
        # Map=set(wordDict)
        dp=[False]*(len(s)+1)
        dp[0]=True
        for i in range(1,len(s)+1):
            for j in range(0,i):
                if dp[j] and s[j:i]  in wordDict:
                    dp[i]=True
                
                    break
        return dp[-1]
    
