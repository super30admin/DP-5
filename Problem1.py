# https://leetcode.com/problems/word-break/

class Solution:
    flag = False
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.myset = set(wordDict)
        self.helper(s, 0)
        return self.flag

    def helper(self, s, pivot):

        if pivot == len(s):
            self.flag = True
            return
        
        for i in range(pivot, len(s)):
            subStr = s[pivot: i+1]

            if subStr in self.myset:
                self.helper(s, i+1)

# Recursive solution without flag. By returning the bool
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.myset = set(wordDict)   
        return self.helper(s, 0)

    def helper(self, s, pivot):

        if pivot == len(s): 
            return True
        
        for i in range(pivot, len(s)): # n
            subStr = s[pivot: i+1] # 2n

            if subStr in self.myset:
                if self.helper(s, i+1): # n
                    return True

        return False

# DP with memoization
# TC: O(n^3)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.myset = set(wordDict) 
        self.memoset = set()  
        return self.helper(s, 0)

    def helper(self, s, pivot):

        if pivot == len(s):
            return True

        sub = s[pivot:]

        if sub in self.memoset: return False
        
        for i in range(pivot, len(s)):
            subStr = s[pivot: i+1]

            if subStr in self.myset:
                if self.helper(s, i+1):
                    return True

        self.memoset.add(sub)

        return False

# DP with tabulation. Resolving smaller sub problems 
# TC: O(n^3)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        myset = set(wordDict)
        n = len(s)
        dp = [False] * (n+1)
        dp[0] = True

        for i in range(1, n+1):
            for j in range(0, i+1):
                if dp[j] and s[j:i] in myset:
                    dp[i] = True
                    break

        return dp[n]