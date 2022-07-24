# time complexity is o(n^3), where n is the size of the input
# space complexity is o(n), where n is the size of the input
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set()
        for word in wordDict:
            if(word not in wordSet):
                wordSet.add(word)
        n = len(s)
        dp = [False for i in range(n+1)] #space is o(n)
        dp[0] = True
        for i in range(1, n+1): #time o(n)
            for j in range(0, i): #time o(n)
                if(dp[j] and (s[j:i] in wordSet)): #time o(n) for substring comparision in set
                    dp[i] = True
                    break
        return dp[n]
                    
                    
        