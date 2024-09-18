// Time Complexity : O(max(n*k, n*n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Check if the 0-j substring and j-i substring is a valid split
// calculate till end of string and return the final value
// dp[j] tells if a element can be split at the index and returns matching words in dict

class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> set = new HashSet<>(wordDict); // n*k -> k=avg length of each word
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        //O(n^2)
        for(int i =1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    //Memoization
    public boolean wordBreakMemo(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<String, Boolean> memoMap = new HashMap();
        return helper(s,set,memoMap);
    }

    private boolean helper(String s, HashSet<String> set, HashMap<String, Boolean> memoMap){
        if(s.length()==0) return true;
        if(memoMap.containsKey(s)) return memoMap.get(s);

        for(int j=0;j<s.length();j++){
            if(set.contains(s.substring(0,j+1)) && helper(s.substring(j+1), set , memoMap)){
                return true;
            }
        }

        memoMap.put(s,false);
        return memoMap.get(s);
    }
}