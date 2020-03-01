//BruteForce
//Time complexity: O(2^n)
class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        //creating set for unique words in dictionary
        set = new HashSet<>(wordDict);
        return helper(s);
    }
    
    private boolean helper(String s){
        //base case
        if(s.length() == 0)
            return true;
            //check till end of string
        for(int i=0; i <= s.length(); i++){
            //if substring from 0->i exists in set
            //return true else false
            if(set.contains(s.substring(0,i)) && helper(s.substring(i))){
                return true;
            }
        }
        return false;
    }
}

/******************************************************************************** */

//Optimal Solution
//Time Complexity: O(n^2)
//Space Complexity: O(n)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //creating set for unique words in dictionary
        Set<String> wordDictSet = new HashSet(wordDict);
        //to check if word exists or not
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        //i=1; j=0
        for(int i=1; i<=s.length();i++){
            for(int j=0; j<i; j++){
                //if characters from j->i exists in the set
                //set value in dp as true
                if(dp[j] && wordDictSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}