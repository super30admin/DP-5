import java.util.*;

public class WordBreak {
    //bottom up dp
    HashSet<String> set3;
    public boolean wordBreak3(String s, List<String> wordDict) {
        //TC:O(L^3)
        set3 = new HashSet<>(wordDict); //O(n*l)
        if (s == null || s.length() == 0) return false;

        int n = s.length();

        // dp[i] represents whether s[0...i] can be formed by dict
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);

                if (set.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }

    HashMap<String, Boolean> map2;
    HashSet<String> set2;
    public boolean wordBreak2(String s, List<String> wordDict) {
        // momoization
        set2 = new HashSet<>(wordDict); //O(n*l)
        map2 = new HashMap<>();
        return helper(s);
    }
    private boolean helper2(String s){
        if(s.length() == 0) return true;
        for(int i = 0; i < s.length(); i++){
            String sub = s.substring(0,i+1);
            if(set2.contains(sub)){
                String restOfString = s.substring(i+1);
                if(!map2.containsKey(restOfString)){
                    map2.put(restOfString, helper(restOfString));
                }
                if(map2.get(restOfString))
                    return true;
            }
        }
        return false;
    }
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict); //O(n*l)
        return helper(s);
    }
    private boolean helper(String s){
        if(s.length() == 0) return true;
        for(int i = 0; i < s.length(); i++){
            String sub = s.substring(0,i+1);
            if(set.contains(sub) && helper(s.substring(i+1))){
                return true;
            }
        }
        return false;
    }
}
