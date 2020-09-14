'''
Time Complexity : O(n^2)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Explanation: DP solution in which the recurrence relation is generate substring of every character from the current character,
until we see a word in the dictionary, if the word exists keep checking the word until from the current index until the
start of sentence until you see a True before. If you see a True before then set the current index in the DP array to
True, incase you don't see a True then set it to False. Keep doing this until you reach the end of the array.
Array[n] is the solution
'''


class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        hashSet = set()
        for word in wordDict:
            hashSet.add(word)

        s = "^" + s

        dp = [False for i in range(0, len(s))]
        dp[0] = True
        for i in range(1, len(s)):
            k = i
            while k >= 1:
                if s[k:i + 1] in hashSet and dp[k - 1]:
                    dp[i] = True
                    break
                k -= 1

        return dp[-1]
