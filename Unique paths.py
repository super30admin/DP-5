# TC : O(mn)
# SC : O(n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        lastrow = [1]*n
        
        for i in range(m-1):
            currRow = [1]*n
            for j in range(n-2,-1,-1):
                currRow[j] = currRow[j+1] + lastrow[j]
            lastrow = currRow
        return lastrow[0]
        