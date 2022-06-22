import java.util.HashSet;
import java.util.List;

//Time Complexity : O(l^3) l is length of string s, two loops and finding substring makes cube
//Space Complexity : O(l) dp array
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //Use hashset to store wordDict list
        HashSet<String> set = new HashSet<>(wordDict);
        //use dp array to indicate splits
        boolean[] dp = new boolean[s.length() + 1];
        //make first char as a split
        dp[0] = true;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                //if there is split and the slipt word is in hashset indicate a split
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length -1];
    }
}