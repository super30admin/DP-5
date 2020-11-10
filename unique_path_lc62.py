"""
Name: Srinidhi Bhat
Did it run on LC: No, TLE 

Time Complexity:O(MXN) - O(2^(max(m,n))) - Each call you have two choices - either go down or right
                                          - We can keep doing this, till either one of the dimension gets exhausted 
Space Complexity: O(MXN) - Recursion Stack (Implicit)
"""
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m == 1 or n == 1:
            return 1
        
        return self.uniquePaths(m - 1, n) + self.uniquePaths(m, n - 1)