'''
Solution:
1.	The recursive solution is that
	totalPath (row, col) = totalPath (row - 1, col) + totalPath (row, col - 1)
						 = 1 if only one row or one col # base case
2.	Can be solved by filling a 2D matrix or by using 1D array and manipulate values 
	accordingly.

Time Complexity:	O(m x n) for both 
Space Complexity:	O(m x n) for first solution and O(n) for second solution
-- where m is rows and n is columns

--- Passed all testcases successfully on leetcode for both the solutions.
'''


class UniquePaths_SubOptimal:
    def uniquePaths(self, m: int, n: int) -> int:
        
        #	initialize with 1s
        paths = [ [1 for c in range(n)] for r in range(m) ]
        
        #	fill from second row, second column using above recurrence relation
        for r in range(1, m):
            for c in range(1, n):
                paths[r][c] = paths[r-1][c] + paths[r][c-1]
        
        #	return the last cell      
        return paths[m-1][n-1]


class UniquePaths_Optimal:
    def uniquePaths(self, m: int, n: int) -> int:
        
        #	initialize with 1s
        paths = [1 for c in range(n)]
        
        #	fill from second row, second column using above recurrence relation and update the same list.
        for r in range(1, m):
            for c in range(1, n):
                paths[c] = paths[c] + paths[c-1]
        
        #	return the last value      
        return paths[n-1]