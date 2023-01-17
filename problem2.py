#time complexity: O(m*n)
#space complexity: O(n)
#ran on leetcode: Yes
#For each element in dp, the number of paths till (i,j) is given by number of paths at (i-1,j) + (i,j-1)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        L=[1]*n
        #print(L)
        for i in range(1,m):
            for j in range(1,n):
                L[j]=L[j]+L[j-1]
        return L[-1]
