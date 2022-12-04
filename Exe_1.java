class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set <String> words = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;

        for(int start = n-1; start>=0; --start){
            int end = start;
            String word = "";
            while(end<n){
                word += s.charAt(end);

                if(words.contains(word) && dp[end+1]){
                    dp[start] = true;
                    break;
                }

                ++end;
            }
        }

        return dp[0];
    }
}
//tc=O(n^3)
//sc=O(n)
