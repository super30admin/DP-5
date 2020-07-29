# time complexity - O(mn)
# space complexity - O(mn) 
# does this code run on leetcode? : yes
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # populate the paths 
        paths = [[1 for _ in range(n)] for _ in range(m)]
        # populate the array from bottom up
        # at every point, robot can either move to the right or down.
        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                paths[i][j] = paths[i+1][j] + paths[i][j+1] # sum up the paths
        
        return paths[0][0]


# using recursion
# traverse every path
# time complexity - O(2^mn)
# space complexity - O(n+m) = O(t) where t will be m if m>>n or n if n>>m
# does this code run on leetcode? : no (time limit exceeded)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        self.path = 0
        # explore every path
        def traversePath(i, j):
            # when the path reaches the bottom right, increment the number of paths by 1.
            if i == m-1 and j == n-1:
                self.path += 1
            if (i+1) <= m:
                traversePath(i+1, j) # right traversal
            if (j+1) <= n:
                traversePath(i, j+1) # down traversal
        
        traversePath(0, 0)  # begin from the point (0, 0) 
        return self.path
        