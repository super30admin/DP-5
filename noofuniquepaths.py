class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        #TC-O(mn),SC-O(1)
        #at every block, no of ways to reach it are sum of no of ways to reach it stop and left blocks
        #for elements in the frist row and col , no of ways to rach them is 1 from start block
        ans =[[0 for i in range(n)] for j in range(m)]
        for i in range(m):
            ans[i][0]=1
        for j in range(n):
            ans[0][j]=1
        for i in range(1,m):
            for j in range(1,n):
                ans[i][j]= ans[i-1][j]+ans[i][j-1]
        return ans[m- 1][n-1]