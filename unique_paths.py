# time: O(mn)
# space: O(mn)
class Solution(object):
    paths = []
    def uniquePaths(self, m, n):
        self.paths = [[0 for i in range(n)] for j in range(m)]
        return self.helper(self.paths, 0, 0)
    def helper(self, paths, i, j):
        if i >= len(paths) or j >= len(paths[0]):
            return 0
        if i == len(paths) - 1 and j == len(paths[0]) - 1:
            return 1
        if paths[i][j] != 0:
            return paths[i][j]
        right = self.helper(paths, i, j+1)
        bottom = self.helper(paths, i+1, j)
        paths[i][j] = right + bottom
        return paths[i][j]