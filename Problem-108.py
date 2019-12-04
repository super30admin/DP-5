'''
Leetcode - 139. Word Break - https://leetcode.com/problems/minimum-window-substring/
time complexity - O(N^2)
Approach - DP solution, if the word formed is 1 if and only if starting letter is 1
'''


class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
       
        
        if len(s)==0: return True
        wordset=set(wordDict)
        n=len(s)+1
        dp=[False]*n
        dp[0]=True
        
        for i in range(len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in wordset: #pine in dict and p value should be 1
                    dp[i]=True
        return dp[len(dp)-1]
                    



#recursive - got error  - time complexity - o(n^n)

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        if len(s)==0: return True
        wordset=set(wordDict)
        return self.helper(s,wordset)
    
    
    def helper(self,s,wordset):
        
        n= len(s)
        if n==len(s):
            return True
        for i in range(0,n):
            if s[0:i] in wordset:
                if self.helper(s[i:],wordset):
                      return True
        return False
    
    
  
            
                