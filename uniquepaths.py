 #  time complexity: O(m*n)
    #  space complexity:O(n)
    #  optimization
    # create an array of len(n+1) 
    # write a nested loop of m-2 and n-2 len to be filled in reverse
    #  dp[j] when j = n-1 will always be 1
    #  dp[j] will be  dp[j+1] + dp[j]

def uniquePaths(self, m: int, n: int) -> int:
    dp = [1 for _ in range(n+1)]
    for i in range(m-2,-1,-1):
        for j in range(n-2,-1,-1):
            # if j == n-1:
            #     dp[j] = 1
            dp[j] = dp[j+1] + dp[j]
    return dp[0]