// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
dp solution
create grid of m+1, n+1 last row and column is 0
loop over grid from bootom right to top left except last row, col
if bottom right corner the set its value to 1 (destination)
else
current value = sum of right row and bottom column values
return value od dp[0][0]
*/
package main

import "fmt"

func uniquePaths(m int, n int) int {
	//dp soln take 1 row, col extra start from last current value is sum of next row and below column
	dp := make([][]int, m+1)
	for i:=0;i<len(dp);i++ {
		dp[i] = make([]int, n+1)
	}

	//starting at m-1 as m row and n col is 0 only
	for i:=m-1;i>=0;i-- {
		for j:=n-1;j>=0;j-- {
			if i == m-1 && j == n-1 {
				dp[i][j] = 1
			} else {
				dp[i][j] = dp[i+1][j] + dp[i][j+1]
			}
		}
	}
	return dp[0][0]
	//return helper(0, 0, m, n)
}

// recursive solution 2 to power mn
/*func helper(i, j, m, n int) int {
    //base
    if i == m-1 && j == n-1 {
        return 1
    }
    if i>=m || j>= n {
        return 0
    }
    return helper(i+1,j, m, n) + helper(i, j+1, m, n)
}*/

func MainUniquePath() {
	fmt.Println(uniquePaths(7, 3)) //expected 28
}
