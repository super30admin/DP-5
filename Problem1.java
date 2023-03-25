import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
Word Break
approach: if we use exhaustive then the time is O(n^n) since it has repeated sub problems which can be reduced by dp
time: O(mxn)
space: O(n+m*l)
 */
public class Problem1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=0;i<dp.length;i++) {

            for(int j=0;j<i;j++) {
                if(dp[j]) {
                    String jtoi = s.substring(j,i);
                    if(set.contains(jtoi)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[dp.length-1];
    }
    /*
    Exhaustive Approach
        public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }


    private boolean helper(String s, Set<String> set) {
        if(s.length()==0) return true;
        for(int i=0;i<s.length();i++) {
            String prefix = s.substring(0,i+1);
            if(set.contains(prefix) && helper(s.substring(i+1), set))
            return true;
        }
        return false;
    }
     */
}
