//Recursive Solution
class Solution {

    //Time Complexity = 2^mn where m is the rows and n is the columns
    //Space Complexity = m*n (recursive stack)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding : No

    //IN short explain your approach

    int count;
    public int uniquePaths(int m, int n) {
        if(m == 0 && n == 0){
            return -1;
        }
        return recursive(m, n, 0, 0);   //Calling the recursive function by passing the total rows and columns and start position
    }
    public int recursive(int m, int n, int i, int j){
        if(i == m-1 && j == n-1){   //if the robot is managed to reach the last index in the matrix means there is a successful path and we return 1 successful path found
            return 1;
        }
        if(i == m || j == n){   //If any of the index goes out of bounds, means that there is no successful path and we return 0
            return 0;
        }
        int right = recursive(m, n, i, j+1);    //traversing in righ direction at a given cell
        int down = recursive(m, n, i+1, j); //traversing in down direction at a given cell
        return right+down;  //finally we return the sum as that is the total no of paths possible
    }
}

//DP with m*n matrix approach

class Solution {

    //Time Complexity = m*n where m is the rows and n is the columns
    //Space Complexity = m*n (dp matrix)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding : No

    //IN short explain your approach

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1]; //taking 1 larger size than the original matrix
        dp[m-1][n-1] = 1;   //Initializing the last cell as 1 as there is 1 possible path for that cell only.
        for(int i = m-1 ; i >= 0; i--){ //outer loop begins from last row
            for(int j = n-1; j >= 0; j--){  //inner loop begins from last column
                if(i == m-1 && j == n-1) continue;  //we have already set this value to 1 so we ignore this case
                dp[i][j] = dp[i+1][j] + dp[i][j+1]; //as we can see from our algorithm, at any point, the no. of paths is the addition of the right cell + the bottom cell
            }
        }
        return dp[0][0];    //we return the 1st cell as it holds the total no of paths
    }
}

//DP solution with 1d matrix


class Solution {

    //Time Complexity = m*n where m is the rows and n is the columns
    //Space Complexity = n
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding : No

    //IN short explain your approach

    public int uniquePaths(int m, int n) {
        int [] dp = new int [n];
        Arrays.fill(dp, 1); //initially filling all the values with 1
        for(int i = m-2; i >= 0; i--){  //since last row and last column is always 1
            for(int j = n-2; j >= 0; j--){
                dp[j] = dp[j+1] + dp[j];    //dp leftcell + dp rightcell
            }
        }
        return dp[0];
    }
}