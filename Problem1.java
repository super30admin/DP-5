/*
139. Word Break
Ran on leetcode: Yes
TC: O(n^3) (each state does n^2 work for getting substring and looking in hashset)
SC: O(n) memo array
Fix the pivot and check all the possible strings to check if valid split is possible and if valid split is possible return true, if not set the memoization array and return false
*/
class Solution {
    
    private Set<String> words;
    private boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        // Add all the words in set for easier search
        words = new HashSet<>();
        for(String word: wordDict){
            words.add(word);
        }

        //memo array
        memo = new boolean[s.length()];
        Arrays.fill(memo, true);

        boolean result =  helper(s, 0);
        return result;
    }

    public boolean helper(String s, int pivot){
        
        // base case
        if(pivot == s.length()) return true;

        // Check if we have already done this pivot
        if(memo[pivot] != true) return memo[pivot];

        for(int i = pivot; i < s.length(); i++){
            if(words.contains(s.substring(pivot, i + 1))){ // if the dict contains word it is valid path, check next suffix
                if(helper(s, i + 1)){ // if all the suffix are also valid
                    return true;
                }    
            }
        }

        // Remember the false case
        memo[pivot] = false;

        // no valid case
        return false;
    }
}