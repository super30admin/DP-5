//way1
//Recurssion solution
//Travel through given string
//For every iteration: Create a substring from 0th index to curr index. If the substring is present in set, continue.
//i.e., Create another substring from curr+1 index to last index of the string
//At last, length of remaining substring will become 0 --  true case
//If in above iteration, where there is no proper split - last line will be executed and false will be returned
//TC: 2^n
//SC: 2^n
class Solution {
   
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        return helper( s, set);
        
    }

    private boolean helper(String s, Set<String> set){
        //base case
        if(s.length()==0) return true;


        //logic
        for(int i=0;i<s.length();i++){
            String subString=s.substring(0,i+1);
            if(set.contains(subString) && helper(s.substring(i+1,s.length()),set)){
                return true;

            }

        }
        return false;
    }
}


//way2
//Recurssion solution + memoization
//Travel through given string
//For every iteration: Create a substring from 0th index to curr index. If the substring is present in set, continue.
//i.e., Create another substring from curr+1 index to last index of the string
//At last, length of remaining substring will become 0 --  true case
//If in above iteration, where there is no proper split - last line will be executed and false will be returned
//TC: n^2
//SC: n
class Solution {
   Set<String> notPresent=new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        return helper( s, set);
        
    }

    private boolean helper(String s, Set<String> set){
        //base case
        if(s.length()==0) return true;
        if(notPresent.contains(s)) return false; 


        //logic
        for(int i=0;i<s.length();i++){
            String subString=s.substring(0,i+1);
            if(set.contains(subString) && helper(s.substring(i+1,s.length()),set)){
                return true;

            }

        }

        notPresent.add(s);
        return false;
    }
}

//way3
// We use a boolean DP array to represent whether a substring up to a certain index can be segmented into valid dictionary words.

// For each position, we look back at all previous positions and check if the substring between them exists in the dictionary and the previous position is already reachable.

// If both conditions are satisfied, we mark the current position as reachable and proceed with the rest of the string.
//TC: O(l^2)*l
//SC: O(l)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        boolean dp[]=new boolean[s.length()+1];
        Arrays.fill(dp,false);
        dp[0]=true;

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }

        return dp[s.length()];
        
    }
}
