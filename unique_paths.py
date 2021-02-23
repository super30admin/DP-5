# -*- coding: utf-8 -*-
"""
TC:O(MN) where M and N are the lengths and breadths of the grid
SC:O(MN) where M and N are the lengths and breadths of the grid
"""
#this problem is done using DP algorithm
#recursive approach used here
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        total = (m - 1) + (n - 1)
        choice =  min(m-1, n-1)
        denom, num = 1, 1
        for i in range(choice):
            num *= (total-i)
            denom *= (choice-i)
        return num//denom        