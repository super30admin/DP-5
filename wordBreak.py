# Time Complexity:O(N^2)
# SpaceComplexity:O(N) Nvis length of string 


# Approach:
# BruteForce: find all sub string and try out oif their combiantion is possible or not more like split string at idx check s[:idx] in set and then check if new sub string can make splits
#   if s[idx:i+1] in wordSet and helper(i+1) O(2^m*n)
# Memo:we are makingh a lot of calls are made in prev iteration so lets store them using memo matrix .after checking each split we store if we can make new sibstring or not 
#     in future if we encounter same string we use prev stored result O(n^3)
# DP: As seen in treee there are a lot of sub problems that are repeated so we can use dp .Consider you are idx i dp[i] says can we make s[:i-1] using give n words?
#   for every i we take j from start of string if dp[j] is true then see if s[j:i] in wordSet if yes update dp[i] to be true.


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp=[ False for _ in range(len(s)+1)]
        dp[0]=True
        wordSet=set()
        for i in wordDict:
            wordSet.add(i)
        for i in range(len(s)+1):
            for j in range(i):
                if dp[j] and s[j:i] in wordSet:
                    dp[i]=True
                    break
        # print(dp)
        return dp[-1]



class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        #exaustive approach try all combinations
        wordSet=set()
        for i in wordDict:
            wordSet.add(i)
        wordMap=dict()
        idx=0
        def helper(st):
            #base
            if len(st)==0:return True
            if st in wordMap :return wordMap[st]
            #LOGIC
            for i in range(0,len(st)):
                k=st[i+1:len(st)]
                if st[0:i+1] in wordSet and helper(k) :
                    wordMap[st]=True
                    return True
            wordMap[st]=False
            return False
        return helper(s)



class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        #exaustive approach try all combinations
        wordSet=set()
        for i in wordDict:
            wordSet.add(i)
        def helper(idx):
            #base
            if idx==len(s):return True
            if idx>len(s):return False

            #LOGIC
            for i in range(idx,len(s)):
                if s[idx:i+1] in wordSet and helper(i+1) :
                    return True
            return False
        return helper(0)
