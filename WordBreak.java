

public class WordBreak_Exponential {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s,set);
    }
    private boolean helper(String s, Set<String> set){
        // base
        if(s.length()==0) return true;
        // logic
        for(int i=0;i<s.length();i++){
            String sub = s.substring(0,i+1);
            if(set.contains(sub) && helper(s.substring(i+1), set)){
                return true;
            }
        }
        return false;
    }
}

// Time Complexity - exponential

public class WordBreak_DP {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

// Time Complexity - O(n^3)
// Space Complexity - O(ml+n)