# DP-5

## Problem1: (https://leetcode.com/problems/word-break/)

Current Statement
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.

Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]

Output: true
             Explanation: Return true because "leetcode" can be segmented as "leet code".
             
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]

Output: true
             Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".

             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]

Output: false 

## Problem2: (https://leetcode.com/problems/unique-paths/)

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2

Output: 3

Explanation:

From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:

1. Right -> Right -> Down

2. Right -> Down -> Right

3. Down -> Right -> Right

Example 2:

Input: m = 7, n = 3

Output: 28
