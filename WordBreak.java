//In this approach, we use a 1d dp array to store at each index if the substring till the previous index could be split into valid partitions. If yes, then the current index would be true, else false
//For each index, we start from 0 and check if at index has a value true. If yes, then we check the substring from that index to the current index-1 to see if it is present in the word dictionary. If it does present, then we make it true, else false
//Finally, we return the value at the last dp index which tells if the given string could be split into valid partitions where each partition exists in the dictionary
//Time Complexity: O(Nl + n^2) where N is the no. of words in dictionary and l is the avg length of a word and n is the length of the given string
//Space Complexity: O(Nl) for hashset
import java.util.HashSet;
import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        for(int i = 1; i<dp.length; i++){
            for(int j = 0; j<i; j++){
                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
