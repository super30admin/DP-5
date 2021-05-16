class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        if not s :
            return False
        
        hashset = set(wordDict)
        
        dp = [0]* (len(s) +1)
        dp[0] = True
        start, end = 0, 0 
        for i in range(1,len(dp)):
            start = 0
            while start <  i:
                sub_string = s[start:i]
                if dp[start] and sub_string in hashset:
                    #print(sub_string)
                    dp[i] = True
                    break
                start += 1
            #print(dp)
        return dp[-1]
                
            
