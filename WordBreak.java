// Time Complexity - O(n^2+m) n = string len; m = no of words in the dict 
// Space Complexity - O(n) n = str len
// Approach
// Take first cell of dp as true. As the i pointer moves, we take the substring from j to i and
// check if the substring is in the hashset and mark the ith position as true.
// If the dp[j] is true, substring is not in the set move the j pointer and create the substring to check 
// if the set contains the substring further.

//optimised dp
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
       HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        //dp[j] string before j is valid 
        //rest of the string found  between j and i in set then true
        
        if(s.length() == 0 ) return true;
        
        for(int i = 0 ; i < dp.length;i++){
            for(int j = 0 ; j < i ; j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }return dp[dp.length-1]; //populate  dp and give out last value
    }
}

//Brute force
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s,set);
    }
    private boolean helper(String s , HashSet set){
        //base
        if(s.length() == 0 ) return true; // empty string at the end is left hence true
        //logic
        for(int i = 0 ;i<= s.length();i++){ //substring acts 1 set ahead
            //leet present in hashset and can be divided into parititions further
            if(set.contains(s.substring(0,i)) && helper(s.substring(i),set)){
                return true;
            }
        }
        return false;
    }
}

/*
Time complexity: O(n^n)
Space Complexity: O(n)
*/