# Problem 1: Unique Paths
## Time Complexity :
O(m*n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def uniquePaths(self, m: int, n: int) -> int:
              dp = [[0]*n]*m
              #Populate row 0 => 1
              for i in range(m):
                  dp[i][0] = 1
              #Populate column 0 => 1
              for j in range(n):
                  dp[0][j] = 1

              for i in range(1,m):
                  for j in range(1,n):
                      dp[i][j] = dp[i-1][j] + dp[i][j-1]

              return dp[m-1][n-1] 
              
# Problem 2: Word Break
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution:
      class Solution:
          def wordBreak(self, s: str, wordDict: List[str]) -> bool:
              hashset=set()
              #print(type(set))
              for word in wordDict:
                  hashset.add(word)
              s='^'+s
              isValid=[False]*len(s)
              isValid[0]=True
              for i in range(1,len(s)):
                  k=i
                  while(k>=1):
                      if s[k:i+1] in hashset and isValid[k-1]:
                          isValid[i]=True
                          break
                      k-=1
              return isValid[len(s)-1]
