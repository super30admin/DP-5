//DP approach
//Time Complexity : O(n^3). for wach subarray check it takes n^2 and a sunstring is generated each time where the hashset is looked up whether the sunstring is present in dict or not, this adds the extra n time, hence O(n^3).
//Space Complexity : O(n+k). O(n) is the length of dp array and O(k) is the size of hashset.
// Did this code successfully run on Leetcode :yes
// Your code here along with comments explaining your approach
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null||s.length()==0){
            return false;
        }
        //foe easy lookup from dict, use hash set
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        //dp array to store the results of repeating subarrays
        boolean[] dp = new boolean[n+1];
        dp[0] = true;//initially set the first index to true, indicating whatever previous matched. This is done to check if atleast one sunstring is present in the dict from the begining 
        //check each subarray
        for(int i=1;i<n+1;i++){
            for(int j=0;j<i;j++){
                //only if true in dp array check if the subsequent sunarray is in dict
                if(dp[j] == true && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}

//Brute force : Time Linit exceed
//Time Complexity : O(2^n). At every step we can choose to split or not split
//Space Complexity : O(m*n). m is the average length of the string and n (is the size of the set or) the height of recursion tree
class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null||s.length()==0){
            return false;
        }
        //used to lookup from dictionary
        set = new HashSet<>(wordDict);
        return helper(s);
    }
    private boolean helper(String s){
        //if reaches end
        if(s.length()==0){
            return true;
        }
        //check for each substring whether its present in dict or not
        for(int i=0;i<s.length();i++){
            if(set.contains(s.substring(0,i+1)) && helper(s.substring(i+1)))//pass the next substring
            {
                return true;
            }
        }
        return false;
    }
}