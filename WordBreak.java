/*
Time Complexity -  O(n^3)
Space Complexity - O(n) where n is the n length of string 's'.
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {     
        Set<String> dict = new HashSet<String>(wordDict);
        boolean[] wordExists = new boolean[s.length() + 1];
        wordExists[0] = true;

        for(int i = 1; i <= s.length(); i++)
            for(int j = 0; j < i; j++)
                if(wordExists[j] && dict.contains(s.substring(j,i))){
                    wordExists[i] = true;
                    break;
                }
        return wordExists[s.length()];
    }
}
