'''
Solution:
1.  First create a HashSet containing word dictionary for a faster lookup.
2.  For each index from the end, check for each substring from that till the end, if any
    substring is present in the HashSet and substring from next index is already broken.
3.  If yes assign True to that index else False.
Ex - catsanddog         catsandog           dict = {cat, cats, and, sand, dog}
     TFFTTFFTFFT        FFFTTFTFFT  

Time Complexity:    O(n^2)
Space Complexity:   O(n + wd)
                    n - length of string and wd - length of word dictionary

--- Passed all testcases successfully on leetcode.
'''


class WordBreak:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        #   fill the HashSet with words in dictionary
        wordSet = set()
        for word in wordDict:
            wordSet.add(word)
            
        n = len(s)
          
        #   a boolean array to check whether a substring is true at a particular index  
        validityChecks = [ False for i in range(n)]
        validityChecks.append(True)
        
        #   for each index
        for i in range(n - 1, -1, -1):
            #   all substrings from that index till the end
            for j in range(i, n):

                #   current substring and condition for breaking
                word = s[i : j+1]
                if (word in wordSet and validityChecks[j + 1] == True):
                    validityChecks[i] = True
        
        #   if at first character, it turns out to be can be broken => can be broken into words 
        #   of the dictionary, else can't be broken
        return validityChecks[0]
                    