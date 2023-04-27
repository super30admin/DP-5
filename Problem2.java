public class Problem2 {
        public boolean wordBreak(String s, List<String> wordDict) {
            HashSet<String> set = new HashSet<>(wordDict);
            boolean dp[] = new boolean[s.length() + 1];
            for(int i = 1; i < dp.length; i++){
                for(int j = 0; j < i; j++){
                    if(dp[j] && set.contains(s.substring(j,i))){
                        dp[i] = true;
                        break; 
                    }
                }
            }
        }
}
