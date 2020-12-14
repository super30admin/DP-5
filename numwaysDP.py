# As taught in class calculating the max path by adding numbre of paths in down direection with number of path in right dirction
#Time complexity: O(m*n)
#Space Complexity: O(m*n)
m = 3
n= 3
def dpMat(m,n):
    dp = [[0 for i in range(n+1)] for j in range(m+1)]
    print(dp)
    dp[m-1][n-1] = 1
    print(dp)
    for i in range(m-1,-1,-1):
        for j in range(n-1,-1,-1):
            if dp[i][j] == 0:
                dp[i][j] = dp[i+1][j] + dp[i][j+1]
                print(dp)
    return dp[0][0]
d = dpMat(m,n)
print(d)
