// Time Complexity - O(n^2) where n is the length of String S
// Space Complexity - O(n) where n is the length of String S
// This solution worked on LeetCode
// This problem has repeated subproblems and dp would be one of the optimal solution. 

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length(); 
        if(n == 0)  return true;       
        boolean[] dp = new boolean[n+1];        // first dp[0] will be empty and holds true to consider the start for j
        HashSet<String> map = new HashSet<>(wordDict);
        dp[0] = true;
        for(int i=1;i < n+1;i++){   // Iterate over the String S
            for(int j=0;j < i;j++){ // Iterate over j which starts from 0th position in dp till i to get the strings splits which can be the dictionary
                if(dp[j] && map.contains(s.substring(j,i))){    // if true and the map contains the string from j to i in the dictionary make the dp[i] as true
                    dp[i] = true; 
                    break;
                }
            }
        }
        return dp[n];       // if the last element in dp array is true it means all the splits have an entry in the dictionary and return true
    }
}
