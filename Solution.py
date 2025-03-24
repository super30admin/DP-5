'''
// Time Complexity :
# Problem 1 - Brute Force O(n!)
            - DP -- Memoization O(mXn) m - substrings, n - remaining substrings
            - DP -- Pointers O(l*l) l - length of the word dictionary
# Problem 2 - Recursion: O(2^(m+n)) 
            - Memoization O(mxn)
            - Top Down Recursion O(mxn), m - rows and n - columns
// Space Complexity :
# Problem 1 - O(n) n - length of the string
# Problem 2 - All solutions O(mxn), m - rows and n - columns
// Did this code successfully run on Leetcode :
# Yes the code ran successfully.

// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
'''

## Problem 1 - Word Break
# Brute Force (TIME LIMIT EXCEEDED !!)
# Initialize a set and store all the words in dictionary
# Perform recursion using the helper function. Logic - For loop based recursion where we find the 
# substring in the set if one part of the substring is in the set then we find the other part / parts
# of the string
# If all the substrings are in the set we return 'True' else return 'False'

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        set_1 = set(wordDict)
        return self.helper(s, set_1)
    
    def helper(self, s, set_1):
        ## base
        if len(s) == 0: return True
        ## logic
        for i in range(len(s)+1):
            sb = s[:i]
            if sb in set_1 and self.helper(s[i:], set_1):
                return True
        return False

# Dynamic Programming - Memoization
# Store the dictionary words in a set and initialize an empty set to store substrings
# Base case - If length of string is empty return 'True' or if the substring exists in the second set 
# then return 'False'
# Logic - For loop based recursion by creating a substring, check if the substring is in the first set 
# and check the remaining string is in the subset.
# If both strings are found we return 'True' else we store the remaining substring in the second set and
# whenever this is found we do not have to iterate over all the repeated substrings in the second set

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        set_1 = set(wordDict)
        set_2 = set()
        return self.helper(s, set_1, set_2)
    
    def helper(self, s, set_1, set_2):
        ## base
        if len(s) == 0: return True
        if s in set_2: return False
        ## logic
        for i in range(len(s)+1):
            sb = s[:i]
            if sb in set_1:
                rest = s[i:]
                if self.helper(rest, set_1, set_2):
                    return True
                else:
                    set_2.add(rest)
        return False
    
# Dynamic Programming - Pointers
# Store the words from the word dict in a set and create an array of character length of 's' and 
# initialize it as 'False'
# Mark first element in the array as 'True' and traverse over the lenght of this array length and get
# the substring from the indexes of array and start of the string. 
# Loop through each position in the string and check each substring in the set, if it exists no need to 
# check further once we find a valid segmentation
# Return whether the entire string can be segmented

class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        set_1 = set(wordDict)
        n = len(s)
        dp = [False]*(n+1)

        dp[0] = True
        for i in range(1, len(dp)):
            for j in range(0,i):
                if dp[j] and s[j:i] in set_1:
                    dp[i] = True
                    break
        return dp[n] 

## Problem 2 - Unique Paths
# Recursion (TIME LIMIT EXCEEDED)
# Recursively check the path by checking the right and the bottom cell of the matrix
# Base case - bounds check if we return at the last element of the cell return 0 or if we reach the 
# left or right bounds we return 1.
# Check the valid paths until we complete the m x n array and take the sum of right and bottom paths to
# return.

class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        return self.helper(0, 0, m, n)

    def helper(self, i, j, m, n):
        if i == m or j == n:
            return 0

        if i == m-1 and j == n-1:
            return 1

        # Recursively calculate the number of paths by moving down or right.
        bottom = self.helper(i+1, j, m, n)
        right = self.helper(i, j+1, m, n)

        return bottom + right

# Memoization
# Initialize a empty dictionary and recursively find the paths
# Base case - If we reach the last element of the matrix return '0' OR if the right and left bounds is 
# reached then return '1'
# Check if the dictionary already has a value at the row and column combination and return it
# Check the number of paths in the right direction and paths in bottom direction and update the 
# dictionary at that row and column combination
# Return the sum of right & bottom paths

class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        memo = {}
        return self.helper(0, 0, m, n, memo)

    def helper(self, i, j, m, n, memo):
        if i == m or j == n:
            return 0

        if i == m-1 and j == n-1:
            return 1
        
        if (i,j) in memo:
            return memo[(i,j)]

        # Recursively calculate the number of paths by moving down or right.
        bottom = self.helper(i+1, j, m, n, memo)
        right = self.helper(i, j+1, m, n, memo)

        memo[(i,j)] = bottom + right

        return bottom + right

# TOP DOWN Recursion
# Initialize an array of length of columns and initialize by '1'
# Parse each row and column and increment the paths from the previous cell and return the value in the
# dp array
# Return the value of the last element of the array which is the maximum paths

class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        dp = [1 for i in range(n)]

        for i in range(1,m):
            for j in range(1,n):
                dp[j] = dp[j] + dp[j-1]
        return dp[n-1]
