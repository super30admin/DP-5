# Time Complexity: O(n*m) where n is the size of string and m is the number of values in wordDict
# Space Complexity: O(m) where m is the number of values in wordDict
# Approach: Push 0 index to the set. 
#			Iterate over the string s and check if any substring having start as any value in the set and end as current index is present in the wordDict.
# 			If Present, add the index to the set.
#			Check if length of string s is present in set. If so return true else false
# Problems faced: I had written a redundant code initially for string with single length thinking that it would be an edge case but it wasn't.
#				  Couldn't get the code to run on the first run attempt. 
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        possible_words = set([0])
        for i in range(0,len(s)):
            flag = False
            for j in possible_words:
                if s[j:i+1] in wordDict:
                    flag = True
                    break
            if flag:
                possible_words.add(i+1)
        if len(s) in possible_words:
            return True
        return False
            