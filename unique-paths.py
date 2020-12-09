# Time Complexity: O(m*n)
# Space Complexity: O(m*n)
# Approach: Create a dp table that saves the steps required to get from a prev r,c to a current cell. The recurrence in this case is similar to the fibonacci series recurrence.
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        table = [[1] * n for _ in range(m)]
        
        for row in range(1,m):
            for col in range(1,n):
                table[row][col] = table[row-1][col] + table[row][col-1]
                
        return table[m-1][n-1]