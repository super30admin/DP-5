#-------------- Solution 1 : recursive : Time limit exceed----------
''' Time Complexity :  O(2^)
    Space Complexity : O(n)

'''
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        sett = set(wordDict)
        def helper(pivot, sett):
            if pivot == len(s):
                return True

            for i in range(pivot,len(s)):
                substr = s[pivot:i+1]
                if substr in sett and helper(i+1,sett):
                    return True
            return False
        return helper(0,sett)


#-------------- Solution 2 : recursive : memoization----------
''' Time Complexity :  O(n^2)
    Space Complexity : O(n^2)

'''
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        sett = set(wordDict)
        memo = set()
        def helper(pivot, sett):
            if pivot == len(s):
                return True
            
            sstr = s[pivot:]
            if sstr in memo:
                return False

            for i in range(pivot,len(s)):
                substr = s[pivot:i+1]
                if substr in memo: return False
                if substr in sett and helper(i+1,sett):
                        return True

            memo.add(sstr)
            return False
        return helper(0,sett)

#-------------- Solution 3 : DP solution----------
''' Time Complexity :  O(n^2)
    Space Complexity : O(n)

'''
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        sett = set(wordDict)
        n = len(s)
        dp = [False] * (n+1)
        dp[0] = True
        for i in range(1,n+1):
            j = 0
            while j < i:
                if dp[j]:
                    substr = s[j:i]
                    if substr in sett:
                        dp[i] = True
                        break
                j += 1
        return dp[n]
        
