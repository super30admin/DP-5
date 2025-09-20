// This solution uses a dp based approach to break the word and store the possibility of breaking from that index to make sure we dont repeate the calculation for other paths in DP
// We use dfs to traverse over the work and keep checking the word presence in the set and if its not available we just move otherwise start same search from next index
class Solution {
    boolean found = false;
    boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new boolean[s.length()];
        Set<String> set = new HashSet();
        for(String word: wordDict) set.add(word);
        findString(s, set, 0);
        return found;
    }

    private void findString(String s, Set<String> set, int pivot) {
        // base cases
        if(pivot==s.length()) {
            found=true;
            return;
        }

        if(dp[pivot]) return;

        for(int i=pivot;i<s.length();i++) {
            if(found) return;
            String temp = s.substring(pivot, i+1);
            if(!set.contains(temp)) {
                continue;
            }
            findString(s, set, i+1);
        }

        dp[pivot] = true;
    }
}
