import java.util.HashSet;
import java.util.List;
import java.util.Set;

class WordBreak {
    // Time Complexity: Nl + l^l where N is the number of the strings in dictionary
    // and l is the length of the longest word in the dictionary

    // Space Complexity: O(Nl) where l is the length of the longest word in the dictionary
    public boolean wordBreakRecursive(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);

        return helper(s, set);
    }

    private boolean helper(String s, Set<String> set){
        // base
        if(s.length() == 0){
            return true;
        }

        for(int i = 0; i < s.length(); i++){
            String str = s.substring(0, i+1);

            if(set.contains(str) && helper(s.substring(i+1), set)){
                return true;
            }
        }
        return false;
    }

    public boolean wordBreakMemoization(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();

        Set<String> memoSet = new HashSet<>();

        for(int i = 0; i < wordDict.size(); i++){
            set.add(wordDict.get(i));
        }

        return helperMemoization(s, set, memoSet);
    }

    private boolean helperMemoization(String s, Set<String> set, Set<String> memoSet){
        // base
        if(s.length() == 0){
            return true;
        }

        if(memoSet.contains(s)){
            return false;
        }

        for(int i = 0; i < s.length(); i++){
            String sb = s.substring(0, i+1);

            if(set.contains(sb)){
                String rest = s.substring(i+1);
                boolean interim = helperMemoization(rest, set, memoSet);
                if(interim){
                    return true;
                }else{
                    memoSet.add(rest);
                }
            }
        }
        return false;
    }

    // Time Complexity: O(N^2) where N is the length of the string
    public boolean wordBreakDP(String s, List<String> wordDict) {
        int n = s.length();

        Set<String> set = new HashSet<>();

        for(int i = 0; i < wordDict.size(); i++){
            set.add(wordDict.get(i));
        }
        boolean[] dp = new boolean[n+1];

        dp[0] = true;

        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

}
