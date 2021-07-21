/*Brute force - recursion 
 * */ 

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        //using BFS
        Queue<Integer> queue  = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<String> set = new HashSet<>(wordDict);
        queue.add(0);

        //visited.add(0);
        // add the index to queue, if there is a substring present in s, such that index + somelength is present in the wordDict, we can
        while(! queue.isEmpty()){

            int start = queue.poll();
            if (visited.contains(start)) continue;

            for (int i = start+1; i <= s.length(); i++){
                if(set.contains(s.substring(start, i))){
                   queue.add(i);
                    if(i == s.length()) return true;
                }
            }
             visited.add(start);
        }



        return false;

    }
}


// DP - from bottom right to top left 
 class Solution {
    public int uniquePaths(int m, int n) {
        // dp top to bottom
        int[][] dp = new int[m+1][n+1];
        //  make first row and col 1
        dp[m-1][n-1] = 1;



        // iterate
        for(int i = m-1; i >= 0; i--){
            for (int j = n-1; j >= 0 ; j--){
                if( i == m-1 && j == n-1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];   // up and left
            }
        }

        return dp[0][0];
    }
}

// dp - from top left to bottom right
//
// class Solution {
    public int uniquePaths(int m, int n) {
        // dp top to bottom
        int[][] dp = new int[m][n];
        //  make first row and col 1
        for (int i = 0 ; i < dp[0].length; i++){
            dp[0][i] = 1;
        }
         for (int i = 0 ; i < dp.length; i++){
            dp[i][0] = 1;
        }


        System.out.println(Arrays.deepToString(dp));
        // iterate
        for(int i = 1; i < dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];   // up and left
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}
