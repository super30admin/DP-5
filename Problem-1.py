#Approach
#Start from the each cell and find the min(right and down) add +1 to it and store the result and return 0,0


#Complexities
#Time : O(m*n)
#Space: O(m*N)


class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        memo = [[0 for _ in range(n)] for _ in range(m)]
        self.helper(m, n, 0, 0, memo)
        if memo[0][0] == 0:
            return 1
        return memo[0][0]

    def helper(self, m, n, i, j, memo):
        if m - 1 == i and n - 1 == j:
            return 1

        if i >= m or j >= n:
            return 0

        if memo[i][j] != 0:
            return memo[i][j]

        case1 = self.helper(m, n, i + 1, j, memo)
        case2 = self.helper(m, n, i, j + 1, memo)
        memo[i][j] = case1 + case2

        return memo[i][j]


