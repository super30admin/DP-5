#Time COmplexity :- O(n^3)
#Time Complexity :- O(n)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hashSet = set(wordDict)
        dp = []
        n = len(s)
        for i in range(n + 1):
            dp.append(False)
        dp[0] = True
        
        for i in range(1, n+1):
            for j in range(i):
                if dp[j]:
                    if s[j:i] in hashSet:
                        dp[i] = True
                        break
        return dp[n]


#Time COmplexity :- O(exponential)
#Time Complexity :- O(n)


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if len(s) == 0:
            return False
        
        if len(wordDict) == 0:
            return False
        
        hashSet = set(wordDict)
        
        return self.helper(s, hashSet)

    def helper(self, s, hashSet):
        # Base condition
        if len(s) == 0:
            return True

        #logic
        for i in range(1, len(s)+1):
            if s[0:i] in hashSet and self.helper(s[i:], hashSet):
                return True
        return False