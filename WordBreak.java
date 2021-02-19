// TC: O(N^3), N-> length of string
// SC: O(N) 
// Did it runsucessfully on Leetcode? : Yes
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if ( s == null || s.length() == 0 )
            return false;
        HashSet<String> set = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for ( int i = 1; i < dp.length; i++ )
        {
            for ( int j = 0; j < i; j++)
            {
                if (dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}

// TC: O(N^N), N-> length of string
// SC: O(N)
// Did it run sucessfully on Leetcode? : Yes, TLE on submission
// class Solution {
//     HashSet<String> set;
//     public boolean wordBreak(String s, List<String> wordDict) {
//         if ( s == null || s.length() == 0 )
//             return false;
//          set = new HashSet(wordDict);
//         return helper(s);
//     }
//     private boolean helper(String s)
//     {
//         //base
//         if (s.length() == 0)
//            return true;
        
//         //logic
//         for ( int i = 0; i < s.length(); i++)
//         {
//             if ( set.contains(s.substring(0, i+1)) && helper(s.substring(i+1)))
//                 return true;
//         }
//      return false;
//     }
// }
