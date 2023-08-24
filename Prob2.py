class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        #Method 1 - Brute force check all permutations using For loop based recursion -> TC N^N and SC -> N
        # s1=set(wordDict)

        # def helper(s,pivot):
        #     #base
        #     if pivot==len(s): return True

        #     #logic
        #     for i in range(pivot,len(s)):
        #         sub=s[pivot:i+1]

        #         if sub in s1 and helper(s,i+1):
        #             return True
        #     return False

        # return helper(s,0)

        #Method 2 - Bottom Up DP -> TC N^3 -> 2 for loops and substring creation in line 28
        s1=set(wordDict)
        n=len(s)
        dp=[False for _ in range(n+1)]
        dp[0]=True #set 0th to True

        for i in range(1,n+1): #i from 1 to n
            for j in range(i): #j from 0 to i
                if dp[j] and s[j:i] in s1: #1. if dp[j] is true-> if this isn't true then we know the characters before it couldn't be split at this point, then no point in checking the  s[j:i]
                #2. then if s[j:i] isn't s1 do nothing move j
                    dp[i]=True 
                    break 
        
        return dp[-1]


        