// Time Complexity : O(n2)
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
dp solution
create map out of dictionary
create new array of n+1 size
set first element of array to true
loop over the array starting at 1
inside loop over starting from 0 to i
check if substring between j,i is present in dictionary and dp[j] is true then set dp[i] to true and break

return last element of dp
*/
package main

import "fmt"

func wordBreak(s string, wordDict []string) bool {
	if len(s) == 0 || len(wordDict) == 0 {
		return false
	}
	m = make(map[string]bool)
	for i:=0;i<len(wordDict);i++ {
		m[wordDict[i]] = true
	}
	//return helper(s)

	//dp soln
	dp := make([]bool, len(s)+1)
	dp[0] = true
	for i:=1;i<len(dp);i++ {
		for j:=0;j<i;j++ {
			_, ok := m[s[j:i]]
			if dp[j] && ok {
				dp[i] = true
				break
			}
		}
	}
	return dp[len(dp) - 1]
}
// brute force, n!
var m map[string]bool
/*func helper(s string) bool {
    if len(s) == 0 {
        return true
    }
    for i:=0;i<len(s);i++ {
        temp := s[:i+1]
        temp1 := s[i+1:]
        _, ok := m[temp]
        if ok && helper(temp1) {
            return true
        }
    }
    return false
}*/

func MainWordBreak() {
	fmt.Println(wordBreak("leetcode", []string{"leet", "code"})) //true
}


