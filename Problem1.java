package DP-5;
// TC: O(m*n*K)
// SC: O(n)
public class Problem1 {
    HashSet<String> wordSet;
    HashMap<String, Boolean> memoMap;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordSet = new HashSet<>(wordDict);
        this.memoMap = new HashMap<>();
        return dfs(s,0);
    }

    private boolean dfs(String s, int pivot){
        //base
        if(pivot==s.length()) return true;

        //logic 
        for(int i=pivot; i<s.length();i++){
            String subStr = s.substring(pivot,i+1);
            if(wordSet.contains(subStr)){
                String remStr = s.substring(i+1);
                if(!memoMap.containsKey(remStr)){
                    boolean result = dfs(s,i+1);
                    memoMap.put(remStr, result);
                }
                if(memoMap.get(remStr)) return true;
            }
        }

        return false;
    }
}
