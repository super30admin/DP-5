// Using recursion and memo table

TC : O(N^2)
It is Top-Down DP with Memoization (DFS + Memo).
For each pivot position in s:
Try all possible substrings starting from pivot, i.e., s[pivot:i+1] for i = pivot to s.length()-1.
For each valid prefix in wordDict, recursively check the suffix (helper(s, i+1)).

SC : O(N)
Where N it the length of the string.


class Solution {
    HashSet<String> set;
    HashMap<Integer , Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        this.map = new HashMap<>();
        return helper(s,0);
    }

    private boolean helper(String s, int pivot){
        // base
        if(pivot == s.length()) return true;
        // memo table
        if(map.containsKey(pivot))
            return map.get(pivot);
        // logic
        for(int i=pivot;i<s.length();++i){
            String substr = s.substring(pivot,i+1);
            if(set.contains(substr) && helper(s,i+1)){
                map.put(pivot , true);
                return true;
            }
        }
        map.put(pivot,false);
        return false;
    }
}
