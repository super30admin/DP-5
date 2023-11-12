// Time Complexity:  O(n^3)
// Space Complexity: O(n)

class Solution {

    Set<String> set;
    List<Integer> indexes;

    public boolean wordBreak(String s, List<String> wordDict) {
        
        set = new HashSet<>(wordDict);
        indexes = new ArrayList<>();
        indexes.add(0);

        for(int j=1; j<=s.length(); j++) {
            for(int k=0; k<indexes.size(); k++) {
                int i = indexes.get(k);                        // get all indexes from list where we found substring
                if(set.contains(s.substring(i, j))) {
                    indexes.add(j);                            // store all indexes where substring found in set
                    break;
                }
            }
        }
        
        int lastIndex = indexes.get(indexes.size()-1);

        return lastIndex == s.length();

    }
}



// // ******************** Another Method ********************

// // Time Complexity:  O(n^3)
// // Space Complexity: O(n)

// class Solution {

//     Set<String> set;
//     boolean[] dp;

//     public boolean wordBreak(String s, List<String> wordDict) {
        
//         set = new HashSet<>(wordDict);
//         dp = new boolean[s.length()+1];
//         dp[0] = true;

//         for(int j=1; j<dp.length; j++) {
//             for(int i=0; i<j; i++) {
//                 if(dp[i] && set.contains(s.substring(i, j))) {
//                     dp[j] = true;
//                     break;
//                 }
//             }
//         }

//         return dp[dp.length-1];

//     }
// }
