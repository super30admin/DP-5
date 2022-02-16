'''
Solution:
1.  First create a HashSet containing word dictionary for a faster lookup.
2.  For each index from the end, check for each substring from that till the end, if any
    substring is present in the HashSet and substring from next index is already broken.
3.  If yes assign True to that index else False.
Ex - catsanddog         catsandog           dict = {cat, cats, and, sand, dog}
     TFFTTFFTFFF        FFFTTFTFFF 
Time Complexity:    O(n^2)
Space Complexity:   O(n + wd)
                    n - length of string and wd - length of word dictionary
--- Passed all testcases successfully on leetcode.
'''

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        wordSet = set()
        for word in wordDict:
            wordSet.add(word)
            
        n = len(s)
        dp = []
        dp = [False for i in range(0,len(s)+1)]
        dp[0] = True
        print(dp)
        
        for i in range(0,n+1):
            for j in range(i):
                if dp[j] and s[j:i] in wordSet:
                    dp[i] = True
                    break
        print(dp)
        return dp[n]