//Recursive approach
class Solution {

    //Time Complexity : 0(2^n) where n is the length of the string
    //Space Complexity : 0(n)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief explain your code

    HashSet<String> set;    //We are declaring a hashset to store the words in the word dict so that we can lookup if the substring of s exists in our dict or not in 0(1) time
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        return helper(s, set);
    }
    public boolean helper(String s, HashSet<String> set){
        if(s.length() == 0){    //If the string has reached it's end means that the entire string is traversed and all the substrings are found
            return true;
        }
        for(int i = 0; i < s.length(); i++){   //we use a for loop based recursion
            if(set.contains(s.substring(0, i + 1)) && helper(s.substring(i+1),set)){    //extracing the substring from 0 to i and checking if it is present in our hashset or not as well as calling the function recursively from i + 1  in order to create babies of remaining string and check the same
                return true;
            }
        }
        return false;   //returning false if the babies aren't present in the hashset
    }
}

//DP approach
class Solution {

    //Time Complexity : 0(n^3) + 0(m) where n is the length of the string and m is the length of the dict
    //Space Complexity : 0(m+n)
    //Did it successfully run on leetcode: Yes
    //Did you face any problem while coding: No

    //In brief explain your code

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);  //declaring a hashset to store the owrds in the dict
        boolean[] dp = new boolean[s.length() + 1]; //taking a dp array to store if a substring from j to i is present in the hashset or not
        dp[0] = true;   //marking 1st cell as true
        for(int i = 1; i <= s.length(); i++){   //i starts from 0 and goes up to length
            for(int j = 0; j < i; j++){ //j begins from 0 and goes up to i
                if(dp[j]){  //a substring will only be checked if that index is marked true
                    String a = s.substring(j, i);
                    if(set.contains(a)){
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()];  //return the last index
    }
}
