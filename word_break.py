class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        # approach 2: dp
        n = len(s)
        hs = set(wordDict)
        dp = [False]*(n+1)
        dp[0] = True

        for i in range(1, len(dp)):
            for j in range(0, i):
                if dp[j] == True:
                    if s[j:i] in hs:
                        dp[i] = True


        return dp[-1]

        # approach 1: brute force => gives Time Limit Exceeded
        n = len(s)
        hs = set(wordDict)
        res = []
        flag = [False]
        
        def recurse(s, idx):
            
            for i in range(idx, n):
                #print(res, s[idx:i+1], idx, i+1)
                if s[idx:i+1] in hs:
                    if (i+1) == n:
                        flag[0] = True
                    res.append(s[idx:i+1])
                    recurse(s, i+1)
                
                if flag[0]:
                    return

        recurse(s, 0)
        return flag[0]

        # "applepen" ["ap","ple", "p", "en"]