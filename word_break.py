# Time Complexity: O(n^2)
# Space Complexity: O()
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The problem here is solved by iteratively checking if the word is present in the dictionary and if it is then recursively 
checking if the remaining word is present in the dictionary as well. The code is made more efficient by using dynamic programming with lru_cache.
"""

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordDict = frozenset(wordDict)

        return True if self.search(s, wordDict) else False

    @lru_cache
    def search(self, word, wordDict):
        for index in range(len(word)):
            if word[:index+1] in wordDict:
                if index == len(word) - 1 or self.search(word[index+1:], wordDict): 
                    return True

        return False
