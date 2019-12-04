'''
BruteForce Approach(checking all possible combinations starting from first letter and drilling down until last letter)
TimeLimit Exceeded on leetcode(139)
time - O(N^N)
space - O(N^N)
'''


class Solution:
    def wordBreak(self, s: str, wordDict) -> bool:
        # Edge case
        if len(s) == 0:
            return True
        HashSet = set(wordDict)  # make a HashSet(O(1) search operation)
        return self.helper(s, HashSet)  # return the output of helper function

    def helper(self, s, HashSet):
        length = len(s)  # length
        # Base Case
        if length == 0: return True

        # Iterate over all possible combinations by using recursion
        for i in range(length + 1):
            if s[0:i] in HashSet and self.helper(s[i:], HashSet):
                # above condition only passes when the word exists in the HashSet
                print(s[0:i])  # Leet # Code( Given Example)
                return True
        return False