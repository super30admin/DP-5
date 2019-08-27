//idea is to iterate over string and check word in dictionary contains in string or not.if yes then set true in dp at index in string where word ends.

//TC:O(stringLength * List length)
//SC:O(stringLength)

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i =1;i<=s.length();i++){
            for(String word : wordDict){
                if(word.length()<=i){
                    if(dp[i-word.length()]){
                        if(s.substring(i-word.length(),i).equals(word) ){
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[s.length()];
    }
	}
