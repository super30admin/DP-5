// Time Complexity : O(n^3)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //edge
        if(s == null || s.length() == 0) return false;
        //create a hashset holding the list of strings to have quick acess to check
        HashSet<String> set = new HashSet<>(wordDict);
        //create a boolean arrea to check
        boolean [] dp = new boolean[s.length()+1];
        //set the first index to true since the one before has nothing to check 
        dp[0] = true;
        //start a for loop going through the boolean area and checking substrings
        for(int i = 1; i < dp.length; i++){
            //int j starts at 0 since we want to check the full word from index 0 of boolean array
            for(int j = 0; j < i; j++){
                //check if the the current value at dp is true and if the substring from starting index til i is in the set
                if(dp[j] && set.contains(s.substring(j,i))){
                    //set the index to be true
                    dp[i] = true;
                    //break since we don't need to check after a true we have found the word in the set
                    break;
                }
            }
        }
        //just return the last index which will tell if it can be partioned accordingly
        return dp[dp.length-1];
    }
}