
//Time Complexity: O(n*m)
//Space Complexity: O(n)    

//we use dynamic programming to solve this problem
//we create a 1D array dp where dp[i] represents whether the substring s[0...i-1] can be segmented into words in the dictionary
//we initialize dp[0] to true because an empty string can always be segmented   
//we then iterate through the string and for each index i, we check all possible substrings s[j...i-1] where 0 <= j < i
//if dp[j] is true and s[j...i-1] is in the dictionary, we set dp[i] to true and break out of the inner loop
//finally we return dp[n] which represents whether the entire string can be segmented into words in the dictionary


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set=new HashSet<>(wordDict);
        int n=s.length();
        boolean dp[]=new boolean[n+1];

        dp[0]=true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}