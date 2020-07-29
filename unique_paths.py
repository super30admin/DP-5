#DP solution

#Time Complexity: O(m*n)
#Space Complexity O(m*n)
'''
Very straightforward dp, we sum the values from the direction it could've come 
from (ways).
'''

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        if m==0 or n==0:
            return 0
        if m==1 or n==1:
            return 1
        dp=[[1]*m for i in range(n)]
        for i in range(1,n):
            for j in range(1,m):
                dp[i][j]=dp[i][j-1]+dp[i-1][j]
        return dp[-1][-1]
  
  
#Combinatorics solution

#Time Complexity: O(1)
#Space Complexity O(1)
'''
We notice that whatever the path , we have to move m-1 case to the right and
n-1 cases down to reach the destinaton (no more, no less). So in total
we have to make (m-1)+(n-1) moves. The sequence of moves is what changes. 
So in these m+n-2 moves, if we choose when we are going down in the sequence of
moves, we know that the rest of moves are moving right.
This means that the number of possible paths is simple choosing where I place my
m-1 moves (going down) in a sequence of m+n-2 moves.

So we automatically get the answer m+n-2 choose m-1. That's
(m+n-2)!/((m-1)!(n-1)!). Now, calculating these factorial still cost
O(m+n) time (which is already much better). But even better, we know that
the integers overflow at around 20!. So we could just keep a global hashtable
(solution class attribute)
of all the factorials until 20, and access them in O(1).
'''

class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        m,n=max(m,n),min(m,n)
        return int(math.factorial(m+n-2)/(math.factorial(n-1)*math.factorial(m-1)))
