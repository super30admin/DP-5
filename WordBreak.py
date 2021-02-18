'''
    Time Complexity:
        O(m*n^2) (where m = length of the string and n = length of the wordDict)

    Space Complexity:
        O(m) (where m = length of the string)

    Did this code successfully run on LeetCode?:
        Yes

    Problems faced while coding this:
        None

    Approach:
        Traverse through the wordDict.
        If the given string starts with a word, recursively check if the rest of
            the word can be made (using the same logic).
        Memoize overlapping subproblems.
'''

class Solution:
    def __init__(self):
        self.wordDict = []
        self.memo = {}

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.wordDict = wordDict
        return self.can_make(s)

    def can_make(self, string):
        if string in self.memo:
            return self.memo[string]

        if string == '':
            return True

        for word in self.wordDict:
            if not string.startswith(word):
                continue

            suffix = string[len(word):]
            if self.can_make(suffix):
                self.memo[string] = True
                return True

        self.memo[string] = False
        return False
