//Time Complexity: O(n^2)
//Space complexity: O(n)
//No edge case needed as it has been specified that the given string would be non-empty

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //Logic
        HashSet<String> set = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length()+1];
        dp[0]=true;
        //Using two pointers, one j to i here would gives us the word
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){ 
                //This gives us the substring from start to that particular word
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }
        return dp[dp.length-1];
    }
}
