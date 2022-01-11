# Time : O(m*n)
# Space: O(n)
class Solution(object):
    def __init__(self):
        self.ans = 0
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        row = [1]*n 
        for i in range(1, m):
            for j in range(1, n):
                row[j] = row[j]+row[j-1]
        return row[n-1]
    
        
