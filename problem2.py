class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        arr=[1]*n
        for i in range(1,m):
            for j in range(1,n):
                val=arr[j]+arr[j-1]
                arr[j]=val
        return arr[n-1]
        #Time O(m*n)
        #Space O(n)
