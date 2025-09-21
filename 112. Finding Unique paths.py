class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        # Initializing a memoization dictionary with the starting cell (0,0) having 1 path
        memo = {(0,0): 1}
        
        # Defining a recursive function to compute the number of unique paths to cell (i, j)
        def paths(i, j):
            # Checking if the result for (i, j) is already computed and stored in memo
            if (i, j) in memo:
                return memo[(i, j)]
            # Handling the case when indices are out of bounds
            elif i < 0 or j < 0 or i == m or j == n:
                return 0
            else:
                # Calculating the number of paths by moving from the left and from above
                val = paths(i, j-1) + paths(i-1, j)
                # Storing the computed value in memo for future reference
                memo[(i, j)] = val
                return val
        
        # Returning the number of unique paths to the bottom-right cell (m-1, n-1)
        return paths(m-1, n-1)

# Time Complexity (TC): O(m * n), since each cell is being computed at most once due to memoization.
# Space Complexity (SC): O(m * n), for storing the memoization dictionary.