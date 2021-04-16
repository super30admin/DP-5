//TC: O(m*n)
//SC: O(n)
class Solution {
    //int x,y;
    public int uniquePaths(int m, int n) {
        //x = m; y = n;
        //return helper(0,0);
        int[] dp = new int[n+1];
        for(int i=m-1;i>=0;i--)
        {
            int[] temp = new int[n+1];
            for(int j=n-1;j>=0;j--)
            {
                if(i==m-1 && j==n-1){   //Starting from the bottom checking how many ways you can reach the end. 
                    temp[n-1] = 1;  //At every point checking the number of ways is defind by the sum of top and right neighbour.
                    continue;       //So, calculating the sum of right and bottm value giving zero at the index out of bound and m-1, n-1 index as 1
                } 
                temp[j] = dp[j]+temp[j+1];
            }
            dp = temp;
        }
        return dp[0];
    }
    /*int helper(int i, int j)
    {
        if(i==x || j==y)
            return 0;
        else if(i==x-1 && j==y-1)
            return 1;
        return helper(i,j+1)+helper(i+1,j);        
    }*/
}