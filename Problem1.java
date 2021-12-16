// //Bottom Up

// class Solution {
//     public boolean wordBreak(String s, List<String> wordDict) {
//         HashSet<String> hs = new HashSet<>(wordDict);
//         boolean dp[] = new boolean[s.length()+1];
//         dp[0] = true;
//         for(int i=1;i<=s.length();i++)
//             for(int j=0;j<i;j++)
//                 if(dp[j] && hs.contains(s.substring(j,i))){
//                     dp[i] = true;
//                     break;
//                 }

//         return dp[s.length()];
//     }
// }

//Top Down
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(new int[s.length()+1], 0, s, new HashSet<String>(wordDict));
    }

    public boolean helper(int dp[], int start, String s, HashSet<String> hs){
        if(start==s.length())
            return true;

        if(dp[start]!=0)
            return dp[start] == 1 ? true:false;

        for(int i=start; i<s.length();i++)
            if(hs.contains(s.substring(start, i+1)) && helper(dp, i+1, s, hs)){
                dp[i] = 1;
                return true;
            }

        dp[start] = -1;
        return false;
    }
}