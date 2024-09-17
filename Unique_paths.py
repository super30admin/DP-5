// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In this we find the unique paths from start to the end .The robot can move only in two directions either to the right or to the down.It means that to reach the cell (i,j) we have to traverse from (i-1,j) and (i,j-1) and add the paths to get the total number of paths at (i,j).
# Time complexity --> o(mn)
# space complexity --> o(mn)
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        matrix=[[0 for i in range(n)]for i in range(m)]
        for i in range(m):
            matrix[i][0]=1
        for i in range(n):
            matrix[0][i]=1
        for i in range(1,m):
            for j in range(1,n):
                matrix[i][j]=matrix[i-1][j]+matrix[i][j-1]
        return matrix[m-1][n-1]
        