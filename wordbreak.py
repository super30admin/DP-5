## Problem1: (https://leetcode.com/problems/word-break/)
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:

        """
        we make a dp matrix of size n+1 where n is the length of the string
        we make use of two pointers i, j where i refers the ending index of the
        current stirng and j somewhere in between i trying to partition

        among s'(0,j) and s'(j+1, i).

        dp[0] is initialzed as true , since the null string is always present in the dictionary, and the rest of the elements of dp as false. We consider substrings of all possible lengths starting from the beginning by making use of index i.

        For every such substring, we partition the string into two further substrings s1 ′ and s2 ′in all possible ways using the index j (Note that the i now refers to the ending index of s2 ′).

        Now, to fill in the entry dp[i], we check
        if the dp[j] contains  true,(  s'(0,j)) i.e. if the substring s1′ fulfills the required criteria.
        If so, we further check if s2'(s'(j+1, i). ) is present in the dictionary. if both strings fulfull we make dp[i] as true`


        TC - O(n cube)
        sc- O(n)
        """
        hashset = set(wordDict)
        dp = [False] * (len(s) + 1)
        dp[0] = True
        for i in range(1, len(s) + 1):
            for j in range(i):
                if dp[j] and s[j:i] in hashset:
                    dp[i] = True
                    break
        return dp[len(s)]



