#Time Complexity: O(n^3)
#Space Complexity: O(n)
'''
for each index , we check all the words created from a valid partition location
to this index (exlusively) if one of them is in the dictionary. If it is, we put
1, else we leave at 0 (meaning we can't partition the word there). There's no
point in checking the words that are made from an index with 0 value to i,
because even if the word was valid, we would know that there wouldn't be any
good partition for that index with value 0.
'''
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s:
            return True
        if not wordDict:
            return False
        
        dp=[0]*(len(s)+1)
        dp[0]=1
        for i in range(1,len(dp)):
            for j in range(1,i+1):
                if dp[i-j]==1:
                    if s[i-j:i] in wordDict:
                        dp[i]=1
                        break
        return dp[-1]
            
