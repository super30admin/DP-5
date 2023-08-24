//Problem 1 - > Word Break
// Time Complexity : O(nk + n^3)
// Space Complexity : O(nk) n=avg length of word in dictionary
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// search for all possible substrings if it is present in dictionary. if yes continue
class Solution {
    //TC: O(nk + n^3) SC: nk n=avg length

    HashMap<String, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set= new HashSet<>(wordDict); //n*k + n^3
        this.map=new HashMap<>();
        return helper1(s,set);




        
        // int n=s.length();

        // boolean[] dp= new boolean[n+1];
        // dp[0]=true;
        // for(int i=1;i<=n;i++){
        //     for(int j=0;j<i;j++){
        //         if(dp[j] && set.contains(s.substring(j,i))){
        //             dp[i]=true;
        //             break;
        //         }
        //     }
        // }
        // return dp[n];


        // return helper(s, set);
    }
    //recursive N^N 
    private boolean helper(String s, HashSet<String> set){
        //base
        if(s.length()==0) return true;

        //logic
        for(int i=0;i<s.length();i++){
            String subString=s.substring(0,i+1);
            if(set.contains(subString) && helper(s.substring(i+1),set)){
                return true;
            }
        }
        return false;
    }

    private boolean helper1(String s, HashSet<String> set){
        //base
        if(s.length()==0) return true;

        //logic
        for(int i=0;i<s.length();i++){
            String subString=s.substring(0,i+1);
            if(set.contains(subString)){
                String rest= s.substring(i+1);

                if(!map.containsKey(rest)){
                    boolean re=helper1(rest,set);
                    map.put(rest,re);
                }
                boolean inter = map.get(rest);
                if(inter)return true;
            }
        }
        return false;
    }
}

//Problem 2 - > Unique Paths
// Time Complexity : O(mn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//check for number of paths from right, then number of paths from down. add them up to get maximum paths. 
//can be done with dp, recursive way. 
class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        //brute force way

        // return helper(0,0,m,n);

        //dp mn mn
        // int[][] dp=new int[m][n];
        // for(int j=0;j<n;j++){
        //     dp[m-1][j]=1;
        // }
        // for(int j=0;j<m;j++){
        //     dp[j][n-1]=1;
        // }

        // for(int i=m-2;i>=0;i--){
        //     for(int j=n-2;j>=0;j--){
        //         dp[i][j]= dp[i+1][j] + dp[i][j+1];
        //     }
        // }
        // return dp[0][0];

        //dp2 mn n
        // int[] dp=new int[n];
        // for(int j=0;j<n;j++){
        //     dp[j]=1;
        // }

        // for(int i=m-2;i>=0;i--){
        //     for(int j=n-2;j>=0;j--){
        //         dp[j]= dp[j] + dp[j+1];
        //     }
        // }
        // return dp[0];

        this.memo=new int[m][n];
        return helper1(0,0,m,n);
    }

    private int helper1(int i, int j, int m, int n){
        //base
        if(i==m-1 && j==n-1) return 1;

        //logic
        int case1=0;

        if(j<n-1){
            if(memo[i][j+1]==0){
                memo[i][j+1]=helper1(i, j+1, m, n);
            }
            case1=memo[i][j+1];
        }
        int case2=0;
        if(i<m-1){
            if(memo[i+1][j]==0){
                memo[i+1][j]= helper1(i+1, j, m, n);
            }
            case2= memo[i+1][j];
        }

        return case1+case2;
    }

    private int helper(int i, int j, int m, int n){
        //base
        if(i==m || j==n) return 0;
        if(i==m-1 && j==n-1) return 1;
        //logic
        int case1=helper(i, j+1, m, n);
        int case2=helper(i+1, j, m, n);

        return case1+case2; 
    }
}