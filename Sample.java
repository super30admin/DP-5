// Problem-1: Word break

/**
DP solution: 
TC = O(n^3) where n is the num of elements in the s string and considering lookup time of a string in the hashset
SC = O(n)
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length()+1]; // extra size of the dp array to consider the last element in the string s
        dp[0] = true; // assuming empty string is valid
        for(int i=1; i<dp.length; i++){
            for(int j=0; j < i; j++){
                
                if(dp[j] && set.contains(s.substring(j,i))){ // if the start index of the particular substring is valid, check further parts of that substring  
                    dp[i] = true; // and mark it as true
                }
            }
        }
        
        return dp[dp.length-1];
        
    }
}

// recursive
class Solution {
    Set<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        
        return helper(s);
    }
    
    private boolean helper(String s){
        //base
        if(s.length() == 0) return true;
        
        
        //recurse and logic
        for(int i=0; i<= s.length(); i++){
            if(set.contains(s.substring(0, i)) && helper(s.substring(i))) return true;
        }
        
        return false;
        
    }
}
// Queue based solution
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
     Set<String> wordDictSet=new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int [] visited = new int[s.length()+1];
        
        queue.add(0);
        // we are going to push last index of the word that we have seen so far in our set of dictionary
        while(!queue.isEmpty()){
            
            // start from the last seen word's index that's present in the worddict
            int start = queue.remove();
            if(visited[start] == 0){ 
                // iterate from that index to the end and look for that substring present in the the set of worddict
                for(int i= start+1; i <= s.length(); i++){

                    String word = s.substring(start, i);

                    if(wordDictSet.contains(word)){
                    // if it is in our dictionary, then note it's last chars index and put it in the queue to continue later on
                        queue.add(i);
                // if we succesfull reached the end of string at this point, that means this string is possible to break with dict
                        if(i == s.length()){
                            return true;
                        }
                    }

                }
                
                visited[start] = 1;
            }
            
        }
        
        return false;
        
    }
}
// Problem -2: Unique paths
// tc = O(m*n) where m is the num of cols and n is num of rows
// Sc = m*n
class Solution {
    public int uniquePaths(int m, int n) {
        
        int [][] dp = new int[n][m];
        
        for(int i=0; i< m; i++){
            dp[0][i] = 1;
        }
        for(int i=0; i< n; i++){
            dp[i][0] = 1;
        }
        
        for(int i=1; i< n; i++){
            for( int j=1; j< m; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[n-1][m-1];
    }
}
