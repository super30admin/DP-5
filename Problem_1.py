# Recursive solution
# Time Complexity: O(n^n)
# Space Complexity: O(n)

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s == None or len(s) == 0:
            return False
        aset = set(wordDict)
        return self.helper(s, aset)
        
    def helper(self, s, aset):
        if len(s) == 0:
            return True
        
        for i in range(1,len(s)+1):
            if s[0:i] in aset and self.helper(s[i:], aset):
                return True
        return False



# Dynamic Programming Solution
# Time Complexity: O(n^4) - Two for loops, one for substring, one for hashset
# Space Complexity: O(n)

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s == None or len(s) == 0:
            return False
        aset = set(wordDict)
        n = len(s)
        dp = [False] * (n + 1)
        dp[0] = True
        for i in range(1, len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in aset:
                    dp[i] = True
                    break
        return dp[len(dp)-1]
        

