#Brute Force!
Time is n raise to power n
and Space is O(n) because i took a temp aray
class Solution:
    def __init__(self):
        self.set1=None
        
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        #hashset banadiya!
        if len(wordDict)==0:
            return False
        self.set1=set(wordDict)
        start=0
        return self.helper(s,start,[])
    def helper(self,s,start,temp):
        if start==len(s):
            return True
        
        for i in range(start,len(s)+1):
            if s[start:i+1] in self.set1 and self.helper(s,i+1,temp):
                temp.append(s[start:i+1])
                temp.pop()
                return True
            
#DP solution
class Solution:        
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if len(s)==0:
            return True
        dp=[None]*(len(s)+1)
        dp[0]=True
        set1=set(wordDict)
        for i in range(len(dp)):
            for j in range(i):
                if dp[j] and s[j:i] in set1:
                    dp[i]=True
        return dp[len(dp)-1]
            
#time complexity is O(n2)
#space complexity is O(n)
