//word Break
//dp 
//tc- O(n*n*n)
//sc- O(n+k) k = word in list
import java.util.*;
public class Problem2 {
    public static void main(String args[]){
        List<String> ls = new ArrayList<>();
        ls.add("leet");
        ls.add("code");
        Problem2 p = new Problem2();
        System.out.println(p.wordBreak("leetcode", ls));

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length()== 0 || wordDict.size()==0){
            return true;
        }
        HashSet<String> hs = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i<=s.length(); i++){
            for(int j = 0;j< i; j++){
                if(dp[j] && hs.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];


    }

    
}
