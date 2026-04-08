# problem 2

#https://leetcode.com/problems/unique-paths/description/

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp_arr = [0]*n
        for i in range(m):
            for j in range(n):
                if i == 0 or j == 0:
                    dp_arr[j] = 1
                else:
                    dp_arr[j] = dp_arr[j] + dp_arr[j-1]
        return dp_arr[-1]