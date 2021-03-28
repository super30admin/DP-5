//time complexity-O(s^2)
//Space complexity-O(s)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean dp[]= new boolean[s.length()+1];
        dp[0]=true;
        int start=0;
        for(int i=1;i<=s.length();i++){
            start=0;
            while(start<i){//checking all the substring idf present in worddict
                if(dp[start] && set.contains(s.substring(start,i))){
                    dp[i]=true;
                    break;
                 }
                 start++;
            }
        }
        return dp[s.length()];
    }
}