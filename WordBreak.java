// Time Complexity : O(n) n is length of string
// Space Complexity : O(n) n is length of string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];

        dp[0]=true;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[dp.length-1];
    }

    public static void main(String [] args){
        WordBreak wb = new WordBreak();
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(wb.wordBreak("leetcode", list));
    }
}