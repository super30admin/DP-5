"""
Approach1: make all possible partitions in the string and check if the word formed by partition is present
or not.
TC: O(n^n)
In this logic, the index (pivot) is sent along with the whole string.
Approach2: DP with memoization
During the recursive call store the substring and if it is valid or not.
TC: O()

Todo: DP + tabulation
"""


class Solution_using_pivot:
    def helper(self, pivot, s, dict_set):
        # base case
        # if we reach the end of the string, this means the word is present in the dictionary.
        # thus return True
        if pivot >= len(s):
            return True

        # recursive case
        # for loop-based recursion is used. Check if the string formed from the
        # pivot to idx is present in the dictionary if yes, return True else,
        # move the idx (or partition) forward, then again check if string from
        # pivot to idx present. Once the for loop is over and string is not present
        # then return False
        for idx in range(pivot, len(s)):
            if s[pivot:idx + 1] in dict_set:
                if self.helper(idx + 1, s, dict_set):
                    return True

        return False

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        # the dict can be saved in the TRIE as well.
        dict_set = set()
        for word in wordDict:
            dict_set.add(word)
        ans = self.helper(0, s, dict_set)
        return ans


class Solution_using_substring:
    def helper(self, sub_str, dict_set):
        # base case
        # since in every recursive call, passing the substring itself, not the index.
        # when the length of substring is 0, it means the reached end.
        if len(sub_str) <= 0:
            return True

        # recursive case
        # forms the substrings from the current substring and checks if new substring is present in
        # the dictionary.
        # if not then increase the idx and then again check
        # if it is present to make the recusive call, from the next index of the current substring
        for idx in range(0, len(sub_str)):
            new_sub_str = sub_str[0:idx + 1]
            if new_sub_str in dict_set:
                if self.helper(sub_str[idx + 1:], dict_set):
                    # self.memo[sub_str] = True
                    return True

        # self.memo[sub_str] = False
        return False

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.memo = {}
        dict_set = set()
        for word in wordDict:
            dict_set.add(word)
        ans = self.helper(s, dict_set)
        return ans


class Solution_memoization:
    def helper(self, sub_str, dict_set):
        # base case
        if len(sub_str) <= 0:
            return True

        # recursive case
        # before startning to solve the problem
        # store the check if it already solved
        if sub_str in self.memo:
            return self.memo[sub_str]
        for idx in range(0, len(sub_str)):
            new_sub_str = sub_str[0:idx + 1]
            if new_sub_str in dict_set:
                if self.helper(sub_str[idx + 1:], dict_set):
                    # while returning back store the result of a smaller sub-problem
                    # in the memo
                    self.memo[sub_str] = True
                    return  self.memo[sub_str]

        # while returning back store the result of a smaller sub-problem
        # in the memo
        self.memo[sub_str] = False
        return False

    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        self.memo = {}
        dict_set = set()
        for word in wordDict:
            dict_set.add(word)
        ans = self.helper(s, dict_set)
        return ans





