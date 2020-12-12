class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        #         def check(s):
        #             if len(s)==0:
        #                 return True
        #             for i in range(len(s)):

        #                 # print(s[:i+1])
        #                 if s[:i+1] in wordDict and check(s[i+1:]):
        #                     return True
        #             return False
        #         return check(s)
        # time-O(N!) space-O(n)
        boo = [False] * (len(s) + 1)
        boo[0] = True
        # print(boo)
        for i in range(len(s)):
            for j in range(i + 1):
                if boo[j] == True and s[j:i + 1] in wordDict:
                    boo[i + 1] = True
        return boo[-1]
        # time-O(n**2) space-O(n)

