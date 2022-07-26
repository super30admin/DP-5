class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # DP TC-O(n**3) SC- O(n)
        dp = [False] * (len(s) + 1)
        dp[0] = True

        for i in range(1, len(s) + 1):
            for word in wordDict:
                if dp[i - len(word)] == True and s[i - len(word): i] == word:
                    dp[i] = True

        # for i in range(1, len(s) + 1):
        #   for j in range(i):
        #       if dp[j] and s[j:i] in wordDict:
        #           dp[i] = True
        #              break

        return dp[-1]

    '''
        # Recursion TC-O(2**n) SC- O(n)
        return self.helper(s,wordDict,0)

    def helper(self,s,wordDict,start):
        if start == len(s):
            return True

        for end in range(start+1,len(s)+1):
            if s[start:end] in wordDict and self.helper(s,wordDict,end):
                return True
        return False
    '''


