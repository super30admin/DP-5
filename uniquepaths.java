//Timecomplexity:- O(mn);
//spacecomplexity:-O(mn);
//Did it run on leetcode:- Yes.
//Your code with approach:- It is a dp problem where initially rows and columns will be filled with 1s and from row 1 and column1
// adding down and right paths value;


class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache=new int[m][n];
        for(int i=0;i<m;i++){
            cache[i][0]=1;
        }
        for(int j=0;j<n;j++){
            cache[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                cache[i][j]=cache[i-1][j]+cache[i][j-1];
            }
        }
       return cache[m-1][n-1] ;
    }
}