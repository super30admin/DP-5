class Solution {
    
// Approach3: Dynamic Programming
// TC : O(n^3) -- n substrings for n partitions(j) for n iterations(i)
// SC :   O(m+n), m is length of worddict and n is length of string for boolean[]
        // boolean[] dp --> to represent if word from 0th till index is present in dict
        // dp[0] = 1 (EMPTY STRING)

        // Eg:  [L,E,E,T,C,O,D,E]     
        //      1,0,0,0,1,0,0,0,1
        // For i = 4, j = 0 ==> [dp[j] = "" && set contains("LEET")]==> true && true ==> 1 (boolean)

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        
        // For the empty string, it is true
        dp[0] = true;
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                // Partition upto j is true && remaining string till i is true ==> both found in dict
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }


    
    
// Approach2: Recursion with Memoization using maps/int[]
// TC : O(n^2) --> Evalauted only when not visited(-1)
// SC : O(m+n) --> O(m+n+n), m is length of worddict, n is length of string for int[], n for recursionstack

        // int[] lookup --> fill with -1 (NOT VISITED)
        // if lookup[-1] ==> build substrings and check if present in Set
        // for valid answer => lookup[s.length()] == 1
    

//     public boolean wordBreak(String s, List<String> wordDict) {
        
//         // Set to check if set contains the substring in O(1)
//         Set<String> set = new HashSet<>(wordDict);
        
        
//         // for the storing the visited and found satus
//         int[] lookup = new int[s.length()+1];    
        
//         Arrays.fill(lookup, -1);
//         return helper(s, set, lookup);
//     }

    
//     public boolean helper(String s, Set<String> set, int[] lookup){
        
//         // Base condition
//         if(s == null || s.length() == 0)
//             return true;
        
//         int len = s.length();
        
//         // Only if not visited, we will evaluate
//         if(lookup[len] == -1){      
            
//             // Marking the index as visited
//             lookup[len] = 0;        
            
//             for( int i = 1; i <= len; i++){
//                 String prefix = s.substring(0, i);
                
//                 // Recursion call
//                 if(set.contains(prefix) && helper(s.substring(i), set, lookup)){
//                     lookup[len] = 1;    // updating for later lookup  
//                     return true;
//                 }
//             }
//         }
//         return lookup[len] == 1;
//     }
    



   
// Approach1: Recursion - TLE
// TC: O(n^n)   - n for for loop, n recursion, n for substring
// SC: O(n+m), n is for recusion stack and m for set
        // List to Set - to search with contains() in Set  in  O(1) TC
        // for loop --> i=0 to n...forming substrings and checking if present in Set
        // Can also use StringBuffer and append the characters instead of substrings
    
//     public boolean wordBreak(String s, List<String> wordDict) {
//         // Set to check with contains in O(1)
//         Set<String> set = new HashSet<>(wordDict);
//         return helper(s, set); p
//     }
    
//     public boolean helper(String s, Set<String> set){
//         // Base condition
//         if(s == null || s.length() == 0)
//             return true;
        
//         for(int i = 1; i <= s.length(); i++){
//         // If the substring from 0 to i partition is in set and the remaining is also in set
//             if( set.contains(s.substring(0,i)) && helper(s.substring(i), set)){
//                 return true;
//             }
//         }
//         return false;
//     }
}