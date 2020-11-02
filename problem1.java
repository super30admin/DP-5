class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordDictSet = new HashSet(wordDict);

        boolean dp[] = new boolean[s.length() + 1];

        dp[0] = true;// string of lenght 0, always in dict

        // S=leetcode
        // j i

        for (int i = 0; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {
                // dp[i] is true when {

                // substring(j,i) in wordDict
                // and dp[j]=true

                // }

                if (dp[j] == true && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }

            }
        }

        return dp[s.length()];
    }
}
// time:O(n^2)
// space:O(n)