# Time Complexity:
# O(n**3),   n = lenght of given "string"

# Space Complexity:  
# O(n+k),    n= len of "string", k is no of words in "dictionary"

# Approach: 
# Dynamic Programming, where we initialie 1D array of len = len(s)+1, and we keep on filling the elements in this array from index 1.
# ===> For each "curr" index, we check if the index at "start" is True, then we check if the substring from 
#      "start" to "curr" index is in the given dictionary, then we set the element at "curr" index in DP array to be "True", and break from inner loop.
# ===> Outer loop is from index 1 to len(string)+1, where we keep of fillinf corr. index in the DP array.
# ===> Finally return the last element of DP array, which says that: 
# "the string from beginning to index "curr-1", can be split in ways that each of the words are found in dictionary.

class Solution(object):
    def __init__(self):
        self.hashSet = []
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        # Approach 2: Dynamic Programming   ==> TC = O(n**3), SC =O(n+k)
        if not s or len(s) == 0:
            return False
        
        # length of given string
        lenS = len(s)

        # create a set from given "wordDict"
        self.hashSet = set(wordDict)

        # dp array for processing
        dp = [False for i in range(lenS+1)]   # array of size lenS+1, where final index element will have our answer

        dp[0] = True # meaning the ""string, i.e "start of the string" is always considered present in dictionary
        
        for curr in range(1, lenS+1):
            for start in range(curr):
                if dp[start] == True:
                    if s[start:curr] in self.hashSet:
                        dp[curr] = True
                        break

        return dp[lenS]
 
        

        