"""
The simple intution behind this solution is that for any point or the current index, the number of paths
which we can use to travel to that point from the starting index is sum of it's adjacent top and left indices,
since the robot can only move adjacently, so we make a dp array to calcuate this, and finally the last index
has the total number of paths available.
Leetcode - Running
Space Complexity - O(N)
Time complexity - O(N)

for a 3*3 matix let us see how -
Intial dp array     final dp array 
    Start
    |
    1  1  1         1   1   1
    1  1  1  -->    1   2   3
    1  1  1         1   3   6
          |
          end
At each index of dp array the value represents the number of ways to reach that point from the starting 
point.
"""
def uniquePaths(self, m, n):
    if(m == 0 or n == 0):
        return 0
    NumberofPaths = [[1] * n]* m
    for i in range(1,m):
        for j in range(1,n):
            NumberofPaths[i][j] = NumberofPaths[i][j-1] + NumberofPaths[i-1][j]
    return NumberofPaths[m-1][n-1]

    