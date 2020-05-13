"""
// Time Complexity : O(n2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Method1 - Memoization (DP) 
- Since there re many overlapping subproblems, we need to cache the results and use it at the time of next call
- We can use a dp dictionary to save the state of the given string and invoke the rec func only if the truth value is not present in the set

Method2 - Bottom-up
- We use dp array to compute the truth value of a given length of the string 
- Two loops will be required, one to iterate over all possible lengths and other to get the substring for each of the lengths
- Break if atleast one true condition is met 
- dp[-1] wil be final answer (True/False)
"""

class Solution:
    def splitstring(self,s,word_dict,dp):
        #print("S",s)
        if s == "":
            #return str in word_dict # ambiguity about base case return stmt
            return True
        #for i in range(len(s)): #failing
        if s in dp:
            return dp[s]
        for i in range(1,len(s)+1): #including last character too
            # print("sub",s[:i])
            # print("post",s[i:])
            #if s[i:] not in dp:
            #dp[s[i:]] = self.splitstring(s[i:],word_dict,dp) # this also works, need not explicitly put True and False like shown below
            #if s[:i] in word_dict and dp[s[i:]]:
            if s[:i] in word_dict and self.splitstring(s[i:],word_dict,dp):
                dp[s[i:]] = True
                return True
        dp[s] = False
        return False
    
    
    # def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    #     word_dict = set(wordDict)
    #     dp = {}
    #     return self.splitstring(s,word_dict,dp)
    
    
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        word_dict = set(wordDict)
        dp = [False]*(len(s)+1)
        dp[0] = True
        for i in range(1,len(s)+1):
            for j in range(0,i):
                print(i,j,dp[j],s[j:i])
                if dp[j] and s[j:i] in word_dict:
                    dp[i] = True
                    break
        return dp[-1]
        
        
        
        