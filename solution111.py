#Time Complexity:O(mn)
#Space Complexity:O(mn)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[[1 for i in range(n)] for j in range(m)] #creating an mxn matrix
        for i in reversed(range(m-1)): 				 #parsing through dp array from backwards
            for j in reversed(range(n-1)):			 
                dp[i][j]=dp[i][j+1]+dp[i+1][j]		 #add the right and bottom elemrnts to current position
        return dp[0][0] 							 #return the topmost left element

#Time Complexity:O(mn)
#Space Complexity:O(n)
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        dp=[1 for i in range(n)] 					#creating an n sized array
        for i in reversed(range(m-1)):				
            right=dp[n-1]							#variable that holds the right element
            for j in reversed(range(n-1)):			#add current value to right and append in same position
                dp[j]=right+dp[j]					#update right value
                right=dp[j]
        return dp[0]								#return first element of resume