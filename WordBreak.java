/*DP - O(N^4) O (N^2) - DP, O(N^3) Substring O(N^4) - contains in hashset
 * */


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp - bottom up
        boolean[] dp = new boolean[s.length() + 1];
        // create a hashset of dictionary
        HashSet<String> set = new HashSet<>(wordDict);

        dp[0] = true;
        for (int i = 1 ; i < dp.length; i++){

            // iterate through j
            for(int j = 0  ; j <= i; j++){
                // if the starting chacter is present and the remainder substring from j - i is present, then add true
                if (dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }

        }

        return dp[dp.length-1];
    }
}

// BFS O(N^3) SC O(N)
//
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
