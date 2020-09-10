class Solution(object):
    def wordBreak(self, s, wordDict):
        wordDict = set(wordDict)
        words = [0]
        for i in range(0,len(s)):
            for word in reversed(words):
                if s[word:i+1] in wordDict:
                    words.append(i+1)
                    if i == len(s) - 1:
                        return True
                    break
    
        return False
#Time-complexity: O(n^2)
#Space-complexity: O(n)