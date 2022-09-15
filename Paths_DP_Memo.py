# Solution using memoization
# Time complexity : O(m*n)
# Space : O(m*n)

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # create a matrix to store the results of paths found from that point
        self.memo = [[0 for _ in range(n)] for _ in range(m)]
        return self.helper(m, n, 0, 0)
    
    def helper(self, m, n, row, col):
        # if we reach the end of the matrix, simply return 1
        if row == m - 1 or col == n-1:
            return 1
        
        # going downwards step
        case1 = 0
        # we can go down till m-1, as we are checking with row + 1
        if row < m-1:
            # if the paths are not calculated for that, only then we call the helper function
            # to update the path on the next level
            if self.memo[row+1][col] == 0:
                self.memo[row+1][col] = self.helper(m,n, row + 1, col)
            # update the case1 value with value from memo
            case1 = self.memo[row+1][col]
        
        # going rightward step
        case2 = 0
        # we can go till last but one column as we are checking for col + 1
        if col < n-1:
            # if the value is not calculated, then simply call the helper function for next col
            if self.memo[row][col+1] == 0:
                self.memo[row][col+1] = self.helper(m,n, row, col+1)
            # store the case2 value to the value recieved by helper function for case2
            case2 = self.memo[row][col+1]
        
        # at any point return the sum of case1 and case2
        return case1 + case2
