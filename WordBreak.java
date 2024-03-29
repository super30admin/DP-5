//Recursion
// Time Complexity : O(Ml + l^l) , M  = number of words in dict, can be very large and we are adding it to the set. l  = length of string
// Space Complexity : O(Ml)
// Did this code successfully run on Leetcode : No, resulted in TLE
// Approach : go exhaustive in finding all possible valid partitions of the string using for loop based recursion and check it if exists in set.

class Solution {
    HashSet<String> set; // we can also use Trie to optimize on space
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }

        return helper(s);
    }

    private boolean helper(String s){
        //base
        if(s.length() == 0){
            return true;
        }

        for(int i = 0 ; i < s.length(); i++){
            String subStr = s.substring(0,i+1);
            String restStr = s.substring(i+1, s.length());

            //if set contains current Sub string and rest of the string can be broken into valid partition
            if(set.contains(subStr) && helper(restStr)){
                return true;
            }
        }
        
        return false;
        
    }
}

// Top down DP

class Solution {
    HashMap<String, Boolean> memo;
    HashSet<String> set; // we can also use Trie to optimize on space
    public boolean wordBreak(String s, List<String> wordDict) {
        this.memo = new HashMap<>();
        this.set = new HashSet<>();
        for(String str : wordDict){
            set.add(str);
        }

        return helper(s);
    }

    private boolean helper(String s){
        //base
        if(s.length() == 0){
            return true;
        }

        if(memo.containsKey(s)) return memo.get(s);

        for(int i = 0 ; i < s.length(); i++){
            String subStr = s.substring(0,i+1);
            String restStr = s.substring(i+1, s.length());

            //if set contains current Sub string and rest of the string can be broken into valid partition
            if(set.contains(subStr)){
                if(helper(restStr)){
                    memo.put(s,true);
                    return true;
                }
                else{
                    memo.put(s,false);
                }

                
            }
        }
        
        return false;
        
    }
}

//Bottom Up approach
// Time Complexity : O(Ml + l^3) , M  = number of words in dict, can be very large and we are adding it to the set. l  = length of string, substring will take is O(l)
// Space Complexity : O(Ml)
// Did this code successfully run on Leetcode : yes
// Approach : Keep checking if the previous substring can be split into valid splits.

class Solution {
   
    HashSet<String> set; // we can also use Trie to optimize on space
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        boolean dp[] = new boolean[s.length()+1];
        dp[0] = true;
        //check if substring before i can be split into valid substrings

        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 0 ; j < i ; j++){
                //substring before j can be split into valid splits
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true; //substring before i can be split into valid splits
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}