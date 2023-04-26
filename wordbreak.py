class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        #TC-O(nK)where n is len(s), k is len(wordDict)
        #SC-O(n)
        #create a dp of length n+1 with last entry as true, now move back along the string and check for each word in dictionary, if its possible with the current char as starting letter, if yes make dp entry true, return dp[0]
        dp = [False]*(len(s)+1)
        dp[len(s)] = True
        for i in range(len(s)-1,-1,-1):
            for w in wordDict:
                if i + len(w) <= len(s) and s[i : i+len(w)] == w:
                    print('yes')
                    dp[i] = dp[i + len(w)]
                if dp[i]:
                    break
        return dp[0] 
       
            
            
