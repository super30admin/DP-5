// Time Complexity : O(n^3)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class WordBreak {
    // TC = n^3;
    // Using Top Down DP - memoization
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<String, Boolean> memoMap = new HashMap<>();
        return helper(s, set, memoMap);
    }

    private boolean helper(String s, HashSet<String> set, HashMap<String, Boolean> memoMap) {
        // base
        if (s.length() == 0)
            return true;
        if (memoMap.containsKey(s))
            return memoMap.get(s);

        // logic
        // permutations
        for (int i = 0; i < s.length(); i++) {
            String currStr = s.substring(0, i + 1);
            if (set.contains(currStr)) {
                boolean restStringResult = helper(s.substring(i + 1), set, memoMap);
                if (restStringResult)
                    return true;
            }
        }
        memoMap.put(s, false);
        return false;
    }
}