import java.util.HashSet;
import java.util.List;

public class WordBreak {

    //https://leetcode.com/problems/word-break/

//TC O(n^4) // SC O(m+n)
/* first we iterate over the string which will give n*2  then we generate
 the substring which will take n and then we iterate over that substring to generate
* the hash for lookup purpose which will take n*/
HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict==null || wordDict.size()==0) return false;
        set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i =1;i<=n;i++){
            for(int j = 0; j<i;j++){
                if(dp[j]){
                    if(set.contains(s.substring(j,i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];


    }




//TC Exponential //SC Max of recursive space or O(n)
    /*
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        if(wordDict==null || wordDict.size()==0) return false;
        set = new HashSet<>(wordDict);
        return helper(s);
    }
    private boolean helper(String s){
        //base
        if(s.length()==0) return true;
        //logic
        for(int i = 0;i<s.length();i++){
            if(set.contains(s.substring(0,i+1)) && helper(s.substring(i+1))) return true;

        }
        return false;
    }*/
}
