class Solution:
    #Solution 1
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        #Approach: Dynamic Programming
        #Time Complexity: O(n^3)
        #Space Complexity: O(n)     // recursion stack
        #where, n is the length of the string
        
        dict = set(wordDict)
        dp = [False for _ in range(len(s) + 1)]
        dp[0] = True
        
        for i in range(1, len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in dict:
                    dp[i] = True
                    break
                    
        return dp[-1]
    
    #Solution 2
    """
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        #Approach: Recursion
        #Time Complexity: O(n^n)
        #Space Complexity: O(n)     // recursion stack
        #where, n is the length of the string
        
        self.dict = set(wordDict)
        self.result = False
        self.helper(s, 0)
        return self.result
    
    def helper(self, s, idx):
        #base
        if idx == len(s):
            self.result = True
            return
        
        #logic
        for i in range(0, len(s) - idx):
            if s[idx : idx + i + 1] in self.dict:
                self.helper(s, idx + i + 1)
    """