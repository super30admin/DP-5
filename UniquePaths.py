class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        """DP Approach using dparray
        Time complexity-O(m*n)
        Space complexity-O(n) where n is the least size between m and n"""
        if m<n:
            return self.uniquePaths(n, m)
        dparr=[1 for i in range(n)]
        for i in range(m-2, -1, -1):
            for j in range(n-2, -1, -1):
                if j+1>n-1:
                    rightval=0
                else:
                    rightval=dparr[j+1]
                dparr[j]=dparr[j]+rightval
        return dparr[0]            
        """DP Approach using DP Array
        Time complexity-O(m*n)
        Space complexity-O(m*n) as using DPmatrix"""
        # dpmatrix=[[0 for i in range(n+1)] for _ in range(m+1)]
        # dpmatrix[m-1][n-1]=1
        # # print(dpmatrix)
        # for i in range(m-1, -1, -1):
        #     for j in range(n-1, -1, -1):
        #         if i!=m-1 or j!=n-1:
        #             dpmatrix[i][j]=dpmatrix[i+1][j]+dpmatrix[i][j+1]
        # return dpmatrix[0][0]
        """Brute force approach 
        time limit exceeded
        Time complexity-O(2^(m*n))
        Space complexity-O(1)"""
#         return self.helper(0, 0, m, n)
    
#     def helper(self, i, j, m, n):
#         if i>=m or j>=n:
#             return 0
#         if i==m-1 and j==n-1:
#             return 1
#         return self.helper(i+1, j, m, n)+self.helper(i, j+1, m, n)
                
        