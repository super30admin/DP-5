#Time Complexity: O(n^3)
#Space Complexity: O(n + mxl) mxl in hashset and n in dp array 

#----------------------------Using DP--------------------------------
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s is None: return False
        hashset = set([])
        for x in wordDict:
            hashset.add(x)
            
        dp = [False for i in range(len(s)+1)]
        dp[0] = True
        for i in range(1, len(s)+1):
            for j in range(i):
                if (dp[j] == True) and s[j:i] in hashset:
                        dp[i] = True
                        break
        if dp[-1] == True: return True
        return False

#---------------Using Recursion()Polynomial Solution-----------------
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s is None: return False
        hashset = set([])
        for x in wordDict:
            hashset.add(x)
            
        return self.helper(s, hashset)
        
    def helper(self, s, hashset):
        #base
        if len(s) == 0: return True
        
        #logic
        for i in range(len(s)):
            if (s[:i+1] in hashset) and self.helper(s[i+1:], hashset):
                return True
            else: continue
        return False