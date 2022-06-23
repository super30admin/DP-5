# TC - O(m * n)
# SC - O(m * n)
class Solution(object):
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        noOfPathArr = [[1] * n for _ in range(m)]

        for row in range(1, m):
            for col in range(1, n):
                noOfPathArr[row][col] = noOfPathArr[row][col - 1] + \
                    noOfPathArr[row - 1][col]

        return noOfPathArr[m - 1][n - 1]
