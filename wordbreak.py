# timecomplexity: N^n
# space complexity:N^n
# leetcode: time limit exceeded
# explination : convert the wordDICt into a set, so that sarching would be O(1). Then iterate through every substring and check if the substring exists in the set. if its there start from the next letter of the substring and recursively call the hlper function to check if the next substring is present in the set


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if s == None:
            return True
        set1 = set(wordDict)
        return self.helper(s, set1)

    def helper(self, string, set1):
        if not string:
            return True
        l = len(string)
        if l == 0:
            return True
        for i in range(l + 1):
            if string[:i] in set1 and self.helper(string[i:], set1):
                return True
        return False


# leetcode:accepted
# time complexity: N^2
# space complexity: O(n)
# explination: we create a dp array of size 1 grete than the length of the string and
# start iterating through the string if the substring exitsts and that point in dp array is true

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        if not s:
            return None
        set1 = set(wordDict)
        dp1 = [0 for i in range(len(s) + 1)]

        dp1[0] = 1
        # print(dp1)
        for i in range(1, len(dp1)):
            for j in range(0, i):
                if s[j:i] in set1 and dp1[j]:
                    dp1[i] = 1
                    print(dp1)
                    print(i, j)
        return dp1[len(dp1) - 1]
