// dp with space complexity as O(n)
// time complexity for both for loops is o(n) and for string opwration its o(n) alltogether o(n3) time complexity
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();

        for(String word: wordDict){
            set.add(word);
        }
        boolean[] dp = new boolean[n +1];
        dp[0] = true;
        for(int i = 1 ; i <= n ; i++){
            for (int j = 0 ; j< i ; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;

                }
             }
        }
        return dp[n];
    }
}
