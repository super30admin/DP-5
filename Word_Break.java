import java.util.HashSet;
import java.util.List;

class Solution {
	//Approach: Dynamic Programming
	//1. We will iterate through the string s and meanwhile will dp array, we will use 2 pointers i and j, where i iterates over string s and j is for checking the substring between j and i.
	//2. If the substring is there in the set and the dp value at j is 1, then the substring part is changed to 1 in dp array, we keep iterating and check if the last element of dp array is 1.
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j] == 1 && set.contains(s.substring(j, i)))
                {
                    dp[i] = 1;
                }
            }
        }
        return dp[n] == 1 ? true: false;
    }
}
//Time Complexity : O(n ^ 2) 
//Space Complexity : O(n) space occupied by the hashset
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :