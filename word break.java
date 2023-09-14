// Time Complexity : O(l^2)
// Space Complexity : O(w+l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach

// DP: We will use two pointer j and i, and we will use a dp array. We will move the i pointer and the j pointer will start from index 0 until ith pointer and check if the substring exists in the dp array. If it does, then it checks if the remaining substring is also present. If yes, then it returns true, otherwise it returns false TC: O() SC: O()
class Solution {
    HashSet set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        int l=s.length();
        boolean dp[]=new boolean[l+1];
        dp[0]=true;

        for(int i=1;i<dp.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[l];
    }
}



// Brute Force: We will store the words in the dictionary in a hashset. We will iterate through the characters of the string, create substring and check if it is present in the hashset and the remaining is also present in it.
class Solution {
    HashSet set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        return dfs(s,0);
    }

    private boolean dfs(String s, int idx)
    {
        //base
        if(idx==s.length()) return true;

        //logic
        for(int i=idx;i<s.length();i++)
        {
            String sub=s.substring(idx,i+1);
            //if the substring and the remaining word is present in the hashset then return true
            if(set.contains(sub) && dfs(s,i+1)) //we will start from i+1, hence we set the idx pointer to i+1
            {
                return true;
            }
           
        }
         //else return false
            return false;
    }
}