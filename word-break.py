# Brut force recursion
# Time O(n)
# Space O(n)
class Solution:
    def __init__(self):
        self.flag = False
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.dfs(s, wordDict, 0, len(s))
        return self.flag

    def dfs(self, s: str, wordDict: List[str], pivot: int, n: int) -> bool:
        if pivot == n: 
            self.flag = True
            return

        for i in range(pivot, n):
            subs = s[pivot: i+1]
            if subs in wordDict:
                self.dfs(s, wordDict, i+1, n)

# Memoization
# Time O(n)
# Space O(n)
class Solution:
    def __init__(self):
        self.flag = False
        self.memo = []

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        self.memo = [-1] * n
        self.dfs(s, wordDict, 0, n)
        return self.flag

    def dfs(self, s: str, wordDict: List[str], pivot: int, n: int) -> bool:
        if pivot == n:
            self.flag = True
            return True

        if self.memo[pivot] != -1: return self.memo[pivot]
        flag = False
        for i in range(pivot, n):
            subs = s[pivot: i+1]
            if subs in wordDict:
                flag = flag or self.dfs(s, wordDict, i+1, n)
        self.memo[pivot] = flag
        return self.memo[pivot]

# DP solution
# Time O(n^2)
# Space O(n+1)   
class Solution:
    
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        dp = [False] * (n+1)
        dp[0] = True
        for i in range(1, n+1):
            for j in range(i):
                if dp[j] == True:
                    subs = s[j: i]
                    if subs in wordDict:
                        dp[i] = True
                        break
        return dp[-1]
        