class Solution {
    Set<String> dictSet;
    public boolean wordBreak(String query, List<String> wordDict) {
        

        
        if(query == null || query.length() ==0) return false;
        dictSet = new HashSet(wordDict);
        
        boolean dp[] = new boolean[query.length()+1];
        dp[0] = true;
        
        for(int i = 1; i< dp.length;i++) {
            for(int j =0;j<i;j++){
                if(dp[j] && dictSet.contains(query.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[query.length()];
        
//         return helper(query);
// //         boolean[] dp = new boolean[query.length() + 1];
// //         dp[0] = true;
// //         for (int i = 1; i <= query.length(); i++) {
// //             for (int j = 0; j < i; j++) {
// //                 System.out.println("string:"+query.substring(j, i));
// //                 if (dp[j] && dictSet.contains(query.substring(j, i))) {
// //                     dp[i] = true;
// //                 }
// //             }
// //         }
        
// //         for(int i=0;i< dp.length; i++) {
// //             System.out.println("dp : "+ dp[i]);
// //         }
        
// //         return dp[query.length()];
//     }
    
//     private  boolean helper(String s){
        
//         // base 
//         if(s.length() ==0) return true;
        
//         // logic
        
//         for(int i=0;i<s.length();i++) {
//             if(dictSet.contains(s.substring(0,i+1)) && helper(s.substring(i+1))){
//                 return true;
//             }   
//         }
        
        
//         return false;
        
        
    }
}
