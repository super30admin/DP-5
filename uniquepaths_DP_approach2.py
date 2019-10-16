# Time Complexity: O(m*n)
# Space Complexity: O(m)
# Approach: Initialize cost matrix of size m to 1.
#			Iterate over cost matrix's 2nd row to m, n times and each time, cost_matrix[i] = += cost_matrix[j-1].
#			Return cost_matrix[m-1]
#
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        cost_matrix = [1] * m
        for i in range(1,n):
            for j in range(1,m):
                cost_matrix[j] += cost_matrix[j-1]
        
        return cost_matrix[m-1]
        