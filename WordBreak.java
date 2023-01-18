//Time Complexity: O(n^3) // n is the leangth of the string
//Space Complexity: O(n^2)

/*
 * maintain a dp array and hashmap of dictionary. for every alphabet
 * we check if the word can be broken down and is part of dictionary.
 * if so we write true in dp array. return the last value of the dp array. 
 */

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String> set = new HashSet<>();
        boolean[] dp = new boolean[n+1];

        for(String word: wordDict){
            set.add(word);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++){
                String sub = s.substring(j, i);

                if(set.contains(sub) && (j == 0 || dp[j])){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}