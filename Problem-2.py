#Approach
#Try all the posibities when we found that the particular will not be in the dict the store it in the memo map so that next time if we encounter the same subproblem we will return


#Complexities
#Time: O(n)
#Space :O(n*L)



from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.hashSet = set(wordDict)
        self.memoSet = set()
        return self.helper(s)

    def helper(self, s):
        if len(s) == 0:
            return True

        if s in self.memoSet:
            return False

        for i in range(0, len(s)):
            substr = s[0:i + 1]
            if substr in self.hashSet and self.helper(s[i + 1:]):
                return True
        self.memoSet.add(substr)
        return False
