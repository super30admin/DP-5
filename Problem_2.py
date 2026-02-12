'''
62 Unique Paths
https://leetcode.com/problems/unique-paths/description/

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2^109.


Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Constraints:
1 <= m, n <= 100

Solution:
1. Recursion:
Pick row or pick column.
This solution is not efficient for larger grids due to its exponential time complexity.
https://youtu.be/St-WLFHcRzw?t=217
Time: O(2^MN), Space: O(1)

2. Bottom-up DP 1:
Initialize a dp matrix of size M x N. dp[i][j] = no. of ways to reach the end starting rom cell i,j. Then dp[i][j] = dp of cell at right + dp of cell at bottom = dp[i][j+1] + dp[i+1][j].
Start from the right bottom corner by setting dp[m-1][n-1] = 1, since if you are at m-1,n-1 and you have to reach the same cell, there is only 1 way of reaching there. We can't say 0 (since that would mean we cannot reach that cell). Continue this process until you reach top left.
https://youtu.be/St-WLFHcRzw?t=683
Time: O(MN), Space: O(MN)

3. Bottom-up DP 2:
Save space by using only 1-D array of DP. We can't do this with just two variables which track bottom and right values of dp.
https://youtu.be/St-WLFHcRzw?t=1509
Time: O(MN), Space: O(N)
'''

def uniquePaths_recur(m: int, n: int) -> int:
    def recurse(m, n, row, col):
        # base
        if row == m or col == n:
            return 0

        if row == m-1 and col == n-1:
            return 1

        # logic
        # move right
        case1 = recurse(m, n, row, col+1)

        # move low
        case2 = recurse(m, n, row+1, col)

        return case1 + case2
    if m == 0 and n == 0:
        return 0
    return recurse(m, n, 0, 0)

def uniquePaths_BottomUp1(m: int, n: int) -> int:
    if m == 0 and n == 0:
        return 0
    dp = [ [0]*(n+1) for _ in range(m+1)]
    dp[m-1][n-1] = 1
    for i in range(m-1,-1,-1):
        for j in range(n-1,-1,-1):
            if i == m-1 and j == n-1:
                continue
            dp[i][j] = dp[i][j+1] + dp[i+1][j]
    return dp[0][0]

def uniquePaths_BottomUp2(m: int, n: int) -> int:
    if m == 0 and n == 0:
        return 0

    # Fill dp = [1,1,1,1..] which represents the last row of DP matrix
    dp =[1]*n

    # Start from 2nd last row and 2nd last col (m-2, n-2)
    for i in range(m-2,-1,-1): # why start with m-2?
        for j in range(n-2,-1,-1): # why start with n-2?
            right = dp[j+1]
            bottom = dp[j]
            dp[j] = right + bottom
    return dp[0]

def run_uniquePaths():
    tests = [(3,3,6), (4,4,20), (3,7,28), (3,2,3), (2,2,2), (1,1,1), (0,0,0)]
    for test in tests:
        m, n, ans = test[0], test[1], test[2]
        print(f"\nGrid rows = {m}, columns = {n}")
        for method in ['recursion', 'DP1', 'DP2']:
            if method == 'recursion':
                ways = uniquePaths_recur(m,n)
            elif method == 'DP1':
                ways = uniquePaths_BottomUp1(m,n)
            elif method == 'DP2':
                ways = uniquePaths_BottomUp2(m,n)
            print(f"Method {method}: Num ways to reach last cell = {ways}")
            success = (ans == ways)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return


run_uniquePaths()
