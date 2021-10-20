package DP5;
//Time complexity : O(n^2)
//Space complexity: O(n)

import java.util.HashSet;
import java.util.List;

public class WordBreak {
    boolean memo[];
    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new boolean[s.length()+1];
        memo[0] = true;
        HashSet<String> words = new HashSet<>(wordDict);
        for(int i=1; i<memo.length; i++){
            for(int j=0; j<i; j++){
                if(memo[j] == true && words.contains(s.substring(j, i))){
                    memo[i] = true;
                    break;
                }

            }
        }
        return memo[memo.length-1];
    }
}
