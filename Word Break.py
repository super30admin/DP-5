# Time:- O(n^3)
# Space:- O(n)
# Approach:- At every index we can make a word that exists in the wordlist we will append that
# index to our dp array and then for every index while iterating the array we will check if the word from the previous indexes to the new index exists in the wordlist or not.
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        my_set=set()
        for i in wordDict:
            my_set.add(i)
        wordnow=""
        dp=[0]
        for i in range(len(s)+1):
            for j in dp:
                if s[j:i] in my_set:
                    # seen a word from one of the previous index to this index memoize this index
                    dp.append(i)
                    break
        if dp[-1]==len(s):
            return True
        return False
                
            
        