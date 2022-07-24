# Time Complexity: O(n^n)
# Space Complexity: O(n)
# DFS solution
class Solution:
    # def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    #     if s==None or len(s)==0: return True
    #     self.hset=set(wordDict)
    #     return self.dfs(s)
    # def dfs(self, s: str):
    #     if len(s)==0: return True
    #     for i in range(len(s)):
    #         substr=s[:i+1]
    #         if substr in self.hset:
    #             if self.dfs(s[i+1:]): return True
    #     return False
# Time Complexity: O(n^2)
# Space Complexity: O(n)
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp=[False for i in range(len(s)+1)]
        hset=set(wordDict)
        dp[0]=True
        # print(dp)
        for i in range(1,len(s)+1):
            for j in range(0,i):
                if dp[j]==True: 
                    if s[j:i] in hset:
                        print(s[j:i])
                        dp[i]=True
                        break        
        return dp[len(s)]