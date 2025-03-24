# DP-5

## Problem1: (https://leetcode.com/problems/word-break/)

# Brute Force (TIME LIMIT EXCEEDED !!)
# Initialize a set and store all the words in dictionary
# Perform recursion using the helper function. Logic - For loop based recursion where we find the 
# substring in the set if one part of the substring is in the set then we find the other part / parts
# of the string
# If all the substrings are in the set we return 'True' else return 'False'

# Dynamic Programming - Memoization
# Store the dictionary words in a set and initialize an empty set to store substrings
# Base case - If length of string is empty return 'True' or if the substring exists in the second set 
# then return 'False'
# Logic - For loop based recursion by creating a substring, check if the substring is in the first set 
# and check the remaining string is in the subset.
# If both strings are found we return 'True' else we store the remaining substring in the second set and
# whenever this is found we do not have to iterate over all the repeated substrings in the second set

# Dynamic Programming - Pointers
# Store the words from the word dict in a set and create an array of character length of 's' and 
# initialize it as 'False'
# Mark first element in the array as 'True' and traverse over the lenght of this array length and get
# the substring from the indexes of array and start of the string. 
# Loop through each position in the string and check each substring in the set, if it exists no need to 
# check further once we find a valid segmentation
# Return whether the entire string can be segmented

## Problem2: (https://leetcode.com/problems/unique-paths/)

# Recursion (TIME LIMIT EXCEEDED)
# Recursively check the path by checking the right and the bottom cell of the matrix
# Base case - bounds check if we return at the last element of the cell return 0 or if we reach the 
# left or right bounds we return 1.
# Check the valid paths until we complete the m x n array and take the sum of right and bottom paths to
# return.

# Memoization
# Initialize a empty dictionary and recursively find the paths
# Base case - If we reach the last element of the matrix return '0' OR if the right and left bounds is 
# reached then return '1'
# Check if the dictionary already has a value at the row and column combination and return it
# Check the number of paths in the right direction and paths in bottom direction and update the 
# dictionary at that row and column combination
# Return the sum of right & bottom paths

# TOP DOWN Recursion
# Initialize an array of length of columns and initialize by '1'
# Parse each row and column and increment the paths from the previous cell and return the value in the
# dp array
# Return the value of the last element of the array which is the maximum paths