#space: O(size of string)
#Time: O(size of string)
# we create a dp array of size n+1
# we check substrings between two iterators j and i only if the substring between 0 and j exists in the dictionary
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        dp= [0]*(len(s)+1)
        dp[0]=1
        hset= set(wordDict)
        for i in range(1,(len(s)+1)):
            for j in range(i):
                if dp[j]==1:
                    if s[j:i] in hset:
                        dp[i]=1
                        break
        if dp[len(s)] ==1:
            return True   
        return False
        
