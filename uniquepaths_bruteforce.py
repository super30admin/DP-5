# Time Complexity: O(number_paths_possible)
# Space Complexity: O(m*n)
# Approach: Initialize cost matrix of size m*n to 0.
#			Do a BFS on the nodes and keep updating the ith, jth value of the cost matrix and continue visiting the visited cells.
#			Return value of m-1,n-1 value in cost matrix 
# Problems faced: This program went into time limit exceeded.
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        cost_matrix = [[0] * n for i in range(m)]
        queue = [(0,0)]
        #cost_matrix[0][0] = 0
        while len(queue) != 0:
            x,y = queue.pop(0)
            #print(x,y)
            cost_matrix[x][y] += 1
            if x+1 <= m-1:
                queue.append((x+1,y))
            
            if y+1 <= n-1:
                queue.append((x,y+1))
                
            
        return cost_matrix[m-1][n-1]