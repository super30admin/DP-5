# Time Complexity O(N^2)
# Space Complexity  O(N)
from typing import List


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        wordDict = set(wordDict)
        split = False
        idx = [n]

        #traversing from the back
        for i in range(n - 1, -1, -1):
            split = False

            for j in idx:
                #storing the start index for which substring is found in wordDict.
                if(s[i: j] in wordDict):
                    split = True
                    idx = [i] + idx
                    break

        return split 
