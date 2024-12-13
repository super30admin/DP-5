//Time Complexity:O(2^m+n)
//Space Complexity: O(m+n)
//https://leetcode.com/problems/unique-paths/description/
class Solution {
    int count;
    public int uniquePaths(int m, int n) {
        helper(m, n, 0,0);
        return count;
    }
    private void helper(int m, int n, int r, int c)
    {
        //base
        if(r==m-1 && c==n-1)
        {
            count++;
            return;
        }
        else if(r>=m ||c>=n) return;
        //logic
        helper(m,n, r, c+1);
        helper(m,n, r+1, c);
    }
}

//Time Complexity:O(m*n)
//Space Complexity:O(m*n)
//https://leetcode.com/problems/unique-paths/description/
class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return helper(m, n, 0,0);
    }
    private int helper(int m, int n, int r, int c)
    {
        //base
        if(r==m-1 && c==n-1)
        {
            return 1;
        }
        else if(r>=m ||c>=n) return 0;

        //logic
        if(memo[r][c]!=0) return memo[r][c];
        
        int case0 = helper(m,n, r, c+1);
        int case1 = helper(m,n, r+1, c);
        memo[r][c] = case0+case1;
        return memo[r][c];
    }
}
// Tabulation
//Time Complexity:O(m*n)
//Space Complexity:O(m*n)
//https://leetcode.com/problems/unique-paths/description/ 
class Solution {    
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=m-1;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if(i==m-1 || j==n-1) 
                {
                    dp[i][j] = 1;
                }
                else
                {
                    dp[i][j]=dp[i][j+1]+dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }
}

//https://leetcode.com/problems/word-break/description/
class Solution {
    //Time complexity: O(n^n) without memoSet
    //Time Complexity with memoMap: O(n^3) where n is the length of the string
    //Space Complexity: O(n*l) where l is the length of the wordDict
    HashSet<String> set;
    HashSet<String> memoSet;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        this.memoSet = new HashSet<>();
        return helper(s);
    }
    private boolean helper(String s)
    {
        if(s.length()==0) return true;
        if(memoSet.contains(s)) return false;
        for(int i =0; i< s.length();i++)
        {
            String subStr = s.substring(0,i+1);
           
            if(set.contains(subStr) && helper(s.substring(i+1)))
            {                
                return true;   
            } 
        }
        memoSet.add(s);
        return false;
    }
}

class Solution {
    //Time complexity: O(n^3) with tabulation where n is the length of the string
    //Space Complexity: O(n*l) where l is the length of the wordDict
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i = 0; i< n+1; i++)
        {
            for(int j=0;j<i;j++)
            {
                if(dp[j] && set.contains(s.substring(j,i)))
                {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }
}
