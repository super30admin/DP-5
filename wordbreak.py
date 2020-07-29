# Time complexity - O(N^N) # where N is the length of the string
# Space complexity - O(N)
# Did this code run on leetcode? - yes
# Did you encounter any issues while coding this? - no
# recursive solution with memoization using hash sets
from functools import lru_cache
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordSet = set(wordDict) # lookup is only O(1) -- actual O(n) in case of strings.
        self.found = False
        
        # recursive function to find the substring
        @lru_cache(None)
        def rec(rem_s):
            # if the remaining string is 0, return True.
            if len(rem_s) == 0:
                self.found = True
                return 
            
            prefix_s = ""
            for i,ch in enumerate(rem_s):
                prefix_s += ch
                # if a prefix is found in the string, recursively find if the remaining substring is in the wordDict.
                if prefix_s in wordSet:
                    rec(rem_s[i+1:])
                
        
        rec(s)
        return self.found


# Time complexity - O(N^N) # where N is the length of the string
# Space complexity - O(N)
# Did this code run on leetcode? - yes
# Did you encounter any issues while coding this? - no
# recursive solution with memoization -- by storing strings in Tries
from functools import lru_cache
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # Trie will take less space, if words have a common prefix.
        # Searching in Trie take same time as hash set.
        wordTrie = self.createTrie(wordDict) 
        self.found = False
        
        # recursive function to find the substring
        @lru_cache(None)
        def rec(rem_s):
            # if the remaining string is 0, return True.
            if len(rem_s) == 0:
                self.found = True
                return 
            
            prefix_s = ""
            for i,ch in enumerate(rem_s):
                prefix_s += ch
                # if a prefix is found in the string, recursively find if the remaining substring is in the wordDict.
                if self.inTrie(wordTrie, prefix_s):
                    rec(rem_s[i+1:])
        
        rec(s)
        return self.found
    
    # Create a Trie 
    # Space complexity (worst case) - O(n)
    def createTrie(self, wordDict):
        trie =  dict()
        # traverse every word in the word dictionary and add it to the trie.
        for word in wordDict:
            root = trie
            for ch in word:
                root = root.setdefault(ch, {})
            root['end'] = True
        return trie
    
    # Search a Trie
    # looking up word in a trie takes O(n) time
    def inTrie(self, trie, word):
        root = trie
        for ch in word:
            if ch not in root:
                return False
            root = root[ch]
        return 'end' in root
        

# Using dynamic programming 
# STEPS:
# Create a dp array of length n+1
# Set dp[0] = 1
# For every location in the string, traverse the prefix till that point and check if there is an already found substring.
# Check for the remaining substring in the prefix from that location. If this substring is present in the hash set, set dp[loc]=1. else, dp[loc]=0.
# Return dp[-1]==1 (check if the entire string can be formed using word dictionary)

# Time complexity - O(N^2) where N is the length of the string
# Space complexity - O(2N) # for trie and for the dp array
# Did this code run on leetcode? - yes
# Did you encounter any issues while coding this? - no
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # Trie will take less space, if words have a common prefix.
        # Searching in Trie take same time as hash set.
        wordTrie = self.createTrie(wordDict) 
        # hashWord = set(wordDict)

        # maintain an array to track substrings.
        dp = [0] * (len(s)+1)
        dp[0] = 1
        
        # traverse the string
        for i, ch in enumerate(s):
            j = 0
            while j <= i:
                if dp[j] == 1 and self.inTrie(wordTrie, s[j:i+1]):
                    #even if one match is found, we can still form the word till that point.
                    dp[i+1] = 1 
                    break
                j+=1
        return dp[-1] == 1
        
        
    # Create a Trie 
    # Space complexity (worst case) - O(n)
    def createTrie(self, wordDict):
        trie =  dict()
        # traverse every word in the word dictionary and add it to the trie.
        for word in wordDict:
            root = trie
            for ch in word:
                root = root.setdefault(ch, {})
            root['end'] = True
        return trie
    
    # Search a Trie
    # looking up word in a trie takes O(n) time
    def inTrie(self, trie, word):
        root = trie
        for ch in word:
            if ch not in root:
                return False
            root = root[ch]
        return 'end' in root
            