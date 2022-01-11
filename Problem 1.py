# Memoization solution
# Time: O(n*n*n)
# Space: O(n*n) If we include stack space
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        dic = set()
        for word in wordDict:
            dic.add(word)
        dp = [-1] * len(s)
        return self.helper(s, dic, 0, dp)
    def helper(self, s, dic, i, dp):
        if i == len(s):
            return True
        if dp[i] == 1:
            return True
        if dp[i] == 0:
            return False
        for j in range(i, len(s)):
            curr = s[i:j+1]
            if curr in dic:
                remaining_string = self.helper(s, dic, j+1, dp)
                if remaining_string == True:
                    dp[i] = 1
                    return True
        dp[i] = 0
        return False
 

# Tabulation
# Time: O(n*n*n)
# SPace: O(n)
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        dic = set()
        for word in wordDict:
            dic.add(word)
        dp = [0]*(len(s)+1)
        for i in range(1, len(s)+1):
            curr = s[0:i]
            if curr not in dic:
                for j in range(1, i):
                    if dp[j] == 1 and s[j:i] in dic:
                        dp[i] = 1 
                        break
            else:
                dp[i] = 1
        if dp[len(s)] == 1:
            return True
        else:
            return Fals
                    
            
        
        
                
            
        
 
