# // Time Complexity : O(n^3)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# using recursion we can check each combination of substring against the words in dictionary
# this approach has repeated subproblems hence we use DP with 1D array
# create array of length lne(s)+1
# we move i in string
# we check if string[0:i] is in dict, if it is then we assign 1 else 0
# also to check if substring from index greater than 0 and i is in dict
# for that we use another for loop with j which check if dp[j:i] in dict
# if it is then also we assign 1
# lastly we return last index value

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        hs = set(wordDict)
        dp = [0]*(len(s)+1)
        dp[0] = 1
        j=0

        for i in range(1, len(s)+1):
            for j in range(0,i):
                if dp[j] == 1 and s[j:i] in hs:
                    dp[i] = 1
                    break
          
        if dp[len(s)]==1:
            return True
        return False