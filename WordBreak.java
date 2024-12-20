// BruteForce Solution - Recursively try to Form all the substrings
// Optimization - continue the recursion only if the partition is valid.
// Time: O(n^n) # at every step you have n choices to split
// space : O(h) # recursive stack space
class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        return helper(s,0);
    }
    public boolean helper(String s,int pivot){
        // base case
        if(pivot == s.length()){
            return true;
        }

        // logic
        for(int i = pivot;i<s.length();i++){
            String subStr = s.substring(pivot,i+1);
            if(set.contains(subStr) && helper(s,i+1)){
                return true;
            }
        }
        return false;
    }
}

// BruteForce Solution - Recursively try to Form all the substrings
// Optimization - continue the recursion only if the partition is valid.
// Extra Optimization - Memoization when the recursion goes back by storing the validity of remaining string in a map so we can resue it
// when you come acorss similar sub problem
// Time: O(n^n) # at every step you have n choices to split
// space : O(h) # recursive stack space
class Solution {
    HashSet<String> set;
    HashMap<String,Boolean> memoMap;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        this.memoMap = new HashMap<>();
        return helper(s,0);
    }
    public boolean helper(String s,int pivot){
        // base case
        if(pivot == s.length()){
            return true;
        }
        String str = s.substring(pivot); // leftOver string
        if(memoMap.containsKey(str)) return memoMap.get(str);

        // logic
        for(int i = pivot;i<s.length();i++){
            String subStr = s.substring(pivot,i+1);
            if(set.contains(subStr) && helper(s,i+1)){
                return true;
            }
        }
        memoMap.put(str,false);
        return false;
    }
}

// Approach : DP withe one dimensional array.
// At any point in time we will check substring before the index is valid partition or not . If yes then check substring is valid word in dict or not.
// If yes then mark that index True
// Time : O(n^2)
// Space : O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set= new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true; // will be empty string before even start of the string
        for(int i =0;i<=n;i++){ // O(l)
            for(int j=0;j<i;j++){ //O(l)
                if(dp[j] == true && set.contains(s.substring(j,i))){ // O(2l)
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[n]; 
    }
}