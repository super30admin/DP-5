/* Time Complexity : O(n^n) 
 *  n - len. of string 's' */
/* Space Complexity : O(h)
 * h - height of the recursive stack */

//Top Down DP

class Solution {
    HashMap<String, Boolean> memoMap;

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        this.memoMap = new HashMap<>();
        return helper(s, set);
    }

    private boolean helper(String s, HashSet<String> set){
        //base
        if(s.length() == 0) return true;
        //logic
        //Exploring all possible substring of the string and then checking if this substring is present in the wordDict(set)
        //If substring is present in the set only then check if remaining string or it's substring is present in the wordDict(set)
        for(int i = 0; i < s.length(); i++){
            String sub = s.substring(0, i + 1);
            if(set.contains(sub)){
                String subStr = s.substring(i+1);
                //Using Memoization
                if(!memoMap.containsKey(subStr)){
                    boolean res = helper(subStr, set);
                    memoMap.put(subStr, res);
                }
                if(memoMap.get(subStr)){
                    return true;
                }
            }
        }
        return false;
    }
}