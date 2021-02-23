# Time Complexity : O(n**2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# We create an array with length one more than the input array. We store True for index 0 which represents empty string. We then at each index see if the prefix
# is in the wordDict. If we reach at the subtring which has true in the array we see of the rest of the sequence is in the array. We return True if the last element
# of the array has true.

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        sett = set()
        for word in wordDict:
            sett.add(word)
            
        memo = [False for x in range(len(s) + 1)]
        memo[0] = True
        
        length = len(s)
        for j in range(1, length+1):
            i = 0
            while i < j:          
                if memo[i] and s[i:j] in sett:
                    memo[j] = True
                    break
                
                i+=1
        print(memo)
        return memo[-1]
