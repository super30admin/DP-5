# TC - O(n ^ 3)
# SC - O(n)
class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        size = len(s)
        isBreakable = [False] * (size)
        for i in range(size):
            if s[:i+1] in wordDict:
                isBreakable[i] = True
            else:
                for j in range(i+1):
                    if isBreakable[j]:
                        if s[j+1:i+1] in wordDict:
                            isBreakable[i] = True

        return isBreakable[size - 1]
