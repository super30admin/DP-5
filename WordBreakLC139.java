class Solution {
    
    //Bottom Up Approach
    //Time Complexity: O(n*n)
    //Space Complexity: O(n)

    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] dp = new boolean[s.length()+1];                   //creating a boolean dp array, which basically stores that at ith index if substring from 0 to i is present in wordDict
        dp[0] = true;                                               //dp[0] = true
        
        Set<String> set = new HashSet<>(wordDict);                  //creating a set from wordDict list, so that we can easily check if word is present in the wordDict without iterating
        
        for(int i=1; i<=s.length(); i++){                           //iterating from i=1 to i<=s.length()
            
            for(int j=0; j<=i; j++){                                  //itearting the j from 0 to i

                if(dp[j]){                                              //check if dp[j] is true

                    String currentString = s.substring(j, i);           //if true then get the substring from j to i
                    
                    if(set.contains(currentString)){                    //check if that substring is present in the set(wordDict)
                        dp[i] = true;                                   //if it's present then mark dp[i] = true
                        break;                                          //break from the inner loop
                    }
                }
            }
        }
        return dp[s.length()];                                      //return dp[s.length()]
    }
    
    
     //Top Down DP Approach
    //Time Complexity: O(n*n)
    //Space Complexity: O(n)


//     int[] dp;
//     public boolean wordBreak(String s, List<String> wordDict) {
        
//         dp = new int[s.length()];
//         Arrays.fill(dp, -1);
        
//         Set<String> set = new HashSet<String>();
        
//         for(String word: wordDict){
//             set.add(word);
//         }
        
//         return wordBreak(s, 0, set);
        
//     }
    
//     public boolean wordBreak(String s, int index, Set<String> set){
        
//         //base
//         if(index == s.length()){
//             return true;
//         }
        
//         if(dp[index] == -1){
            
//             int ans = 0;
//             //recurse
//             for(int j=index; j<s.length(); j++){

//                 String currentString = s.substring(index, j+1);

//                 if(set.contains(currentString)){

//                     boolean remainingString = wordBreak(s, j+1, set);

//                     if(remainingString){
//                         ans = 1;
//                     }
//                 }
//             }
//             dp[index] = ans;
//         }
//         return dp[index] == 1 ? true : false;
        
//     }
    
    
//     //recursive Approach, Gives Time Limit Exceed Error
//     //Time Complexity: O(n^n)
//     //Space Complexity: O(n)


//     public boolean wordBreak(String s, List<String> wordDict) {

//         Set<String> set = new HashSet<String>();
        
//         for(String word: wordDict){
//             set.add(word);
//         }
        
//         return wordBreak(s, 0, set);
        
//     }
    
//     public boolean wordBreak(String s, int index, Set<String> set){
        
//         //base
//         if(index == s.length()){
//             return true;
//         }
        
//         for(int j=index; j<s.length(); j++){
            
//             String currentString = s.substring(index, j+1);
            
//             if(set.contains(currentString)){
                
//                 boolean remainingString = wordBreak(s, j+1, set);
                
//                 if(remainingString){
//                     return true;
//                 }
                
//             }
            
//         }
//         return false;
        
//     }
}
