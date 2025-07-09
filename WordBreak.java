// TC: O(n + n^2) m = length of word in dict
// SC: O(n + m) m = number words in wordDict
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);

        // int[] path = new int[s.length() + 1];
        // Arrays.fill(path, -1);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]) {

                    if (set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        // path[i] = j;
                    }

                }
            }
        }

        // // Print path if true
        // if (dp[dp.length - 1]) {
        //     for (int i : path) {
        //         System.out.print(i + " ");
        //     }
        // }

        return dp[dp.length - 1];
    }
}