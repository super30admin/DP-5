"""
FAANMG Problem #112 {Medium} 

62. Unique Paths

# Time complexity : O(m*n)
# Space complexity : O(m*n) 

Did this code successfully run on Leetcode : Yes

Top Down Recursion

Time Limit Exceeded


@name: Rahul Govindkumar_RN27JUL2022
""" 

class Solution:
    
    def helper(self,m, n ,  row, col):
        
        # if we reach the m and n , simply return 0
        if row == m or col == n:
            return 0
        
        
        # if we reach the end of the matrix, simply return 1
        if row == m - 1 or col == n-1:
            return 1
        
        case1 = self.helper(m, n, row+1, col)
        case2 = self.helper(m, n, row, col+1)
        
        return case1+case2
        
        
    
    def uniquePaths(self, m: int, n: int) -> int:
        
        return self.helper(m, n, 0, 0)


"""
FAANMG Problem #112 {Medium} 

62. Unique Paths

# Time complexity : O(m*n)
# Space complexity : O(m*n) 

Did this code successfully run on Leetcode : Yes

Top Down Recursion

Using Memoization


@name: Rahul Govindkumar_RN27JUL2022
""" 

class Solution:
    
    def helper(self,m, n ,  row, col):
        

        # if we reach the end of the matrix, simply return 1
        if row == m - 1 or col == n-1:
            return 1
        
        # going downwards step
        case1 = 0
        
        # we can go down till m-1, as we are checking with row + 1
        if row < m-1:
            
            # if the paths are not calculated for that, only then we call the helper function
            # to update the path on the next level
            if self.memo[row+1][col]==0:
                self.memo[row+1][col] = self.helper(m, n, row+1, col)
            
            # update the case1 value with value from memo
            case1 = self.memo[row+1][col]
        
        case2 = 0
        
        # we can go till last but one column as we are checking for col + 1
        if col < n-1:
            # if the value is not calculated, then simply call the helper function for next col
            if self.memo[row][col+1]==0:
                self.memo[row][col+1] = self.helper(m, n, row, col+1)
                
            # store the case2 value to the value recieved by helper function for case2
            case2 = self.memo[row][col+1]
        
        return case1+case2
        
        
    
    def uniquePaths(self, m: int, n: int) -> int:
        
        self.memo = [[0 for _ in range(n)] for _ in range(m)]
        
        return self.helper(m, n, 0, 0)



"""
FAANMG Problem #112 {Medium} 

62. Unique Paths

# Time complexity : O(m*n)
# Space complexity : O( min (m,n)) 

Did this code successfully run on Leetcode : Yes

Bottom Up DP


@name: Rahul Govindkumar_RN27JUL2022
""" 

class Solution:
    
 
    def uniquePaths(self, m: int, n: int) -> int:
        
        if m < n:
            return self.uniquePaths(n,m)
        
        # create a dp matrix of size n of all 1's
        dp = [1 for _ in range(n)]
        
        # start from the right and keep on adding values to the matrix
        
        for i in range(m-2, -1 , -1):
            for j in range(n-2, -1 , -1):
                
                dp[j] = dp[j] + dp[j+1] 
        return dp[0]
        
                        