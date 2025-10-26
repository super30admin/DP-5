'''
Solution 1: Recursion
    - at each cell, explore bottom paths and right paths
    - return sum of bottom and right paths at each cell to previous recursive call
    - if we reach target, return 1
    - if we go out of bound, return 0
Time complexity: O(2^(m*n))
Space complexity: O(m+n), Recursive stack. 
'''
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        return self.helper(m,n,0,0)
    
    def helper(self,m,n,row,col):
        # base
        if row==m-1 and col==n-1: # target reached
            return 1
        
        if row==m or col==n: # out of bounds
            return 0

        # logic
        down_paths = self.helper(m,n,row+1,col) 
        right_paths = self.helper(m,n,row,col+1)

        return down_paths+right_paths 


'''
Solution 2: Recursion + Memoization 
    - at each cell, explore bottom paths and right paths
    - return sum of bottom and right paths at each cell to previous recursive call
    - if we reach target, return 1
    - if we go out of bound, return 0
    - Store the total paths discovered at this cell in memory. 
Time complexity: O((m*n))
Space complexity: O(m*n), Memory
'''
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        self.memory = {} # {(row,col) : bottom+right paths}
        return self.helper(m,n,0,0)
    
    def helper(self,m,n,row,col):
        # base
        if row==m-1 and col==n-1: # target reached
            return 1
        
        if row==m or col==n: # out of bounds
            return 0

        # logic
        if (row,col) in self.memory:
            return self.memory[(row,col)]

        down_paths = self.helper(m,n,row+1,col) 
        right_paths = self.helper(m,n,row,col+1)

        self.memory[(row,col)] = down_paths+right_paths # memoization
        return down_paths+right_paths 

'''
Solution 3: DP with Tabulation 
    - Starting from second last row and second last col.
    - bottom_paths = dp_array[current_col] (this is the previous state, ie. row below)
      right_paths = dp_array[current_col+1] (this is right column cell)
    - dp_array[current_col] = bottom_paths + right_paths
Time complexity: O((m*n))
Space complexity: O(n), dp_array 
'''
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp_array = [1]*n  # last row, we will reach target cell going all right, only 1 path

        for i in range(m-2,-1,-1): # second last row -> 0th row
            for j in range(n-1,-1,-1): # second last col -> 0th col
                down_paths = 0
                right_paths = 0
                
                if j!=n-1: # last col, 0 paths exploring right direction
                    right_paths = dp_array[j+1]
                
                down_paths = dp_array[j]

                dp_array[j] = down_paths + right_paths # update dp_array 
        
        return dp_array[0]