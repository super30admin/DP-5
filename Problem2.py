# Time Complexity: O(m * n)
# Space Complexity:O(n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:

        row = [1]* n

        for i in range(0, m-1):
            for j in range(n-2, -1, -1):
                row[j] = row[j+1] + row[j]
            
        return row[0]


