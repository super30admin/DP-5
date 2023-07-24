'''
Problem: Word Break
Time Complexity: O(m*n*l),l - word length in dict, n is length of s, m in total words in dict
Space Complexity: O(n), for dp array
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        applied bottom up DP
        at every character of the word, we check if we have substring
        in dictionary and substring before the character has valid splits.
'''

# Word Break
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        n = len(s)
        arr=[0] * (n+1)
        arr[0] = 1

        for i in range(1, n+1):
            for j in range(i):
                if arr[j]==1 and s[j:i] in wordDict:
                    arr[i]= 1
        
        return arr[n]