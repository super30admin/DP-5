#leetcode 62

#brute force - algo: for every step posiible from the start, we calculate number of ways in which we can reach finish
#there are repeating sub problems in the solution
#got time limit exceeded error
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        return self.helper(0, 0, m, n)  # since we start with 0th and 0th column

    def helper(self, i, j, m, n):
        if i >= m or j >= n:
            return 0  # case when it overshoot
        if i == m - 1 and j == n - 1:
            return 1  # to add up all the possible path
        right = self.helper(i, j + 1, m, n)
        bottom = self.helper(i + 1, j, m, n)
        return right + bottom

#dp problem
#time - o(m*n)
#space - o(m+1*n+1)
#bottom up approach
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        dp = [[0 for i in range(n+1)] for j in range(m+1)]
        dp[m-1][n-1]=1
        #bottom up approach
        for i in range(m-1,-1,-1):
            for j in range(n-1,-1,-1):
                if  i == m-1 and j == n-1:
                    continue;
                dp[i][j] = dp[i][j+1] + dp[i+1][j] #right and bottom
        print(dp)
        return dp[0][0]

    #top down apprach
    class Solution(object):
        def uniquePaths(self, m, n):
            """
            :type m: int
            :type n: int
            :rtype: int
            """
            dp = [[0 for i in range(n + 1)] for j in range(m + 1)]
            dp[1][1] = 1
            # bottom up approach
            for i in range(1, m + 1):
                for j in range(1, n + 1):
                    if i == 1 and j == 1:
                        continue;
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]  # right and bottom
            print(dp)
            return dp[m][n]
