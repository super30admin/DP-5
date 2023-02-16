# Time Complexity :
# O(MN)

# Space Complexity :
# O(N)

# Did this code successfully run on Leetcode :
#Yes

#We do a bottom-up DP - we find the number of paths that take us to the exit from the right bottom corner and start moving backwards. At any position, the number of paths to the exit is the sum of number of paths from the position below and the position next to it. So we add thse values and store it. At the end we return the value at the first position in grid
#This process can be simplified and stored in a single array instead of a grid - we process the last row and keep moving upwards and at each time, the stored grid has the number of paths at the current row we are processing. When we process all rows, grid[0] contains the total required paths


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        grid = [0] * n
        grid[n-1] = 1
        for i in reversed(range(0,m)):
            for j in reversed(range(0,n-1)):
                grid[j] = grid[j+1] + grid[j]
        return grid[0]
