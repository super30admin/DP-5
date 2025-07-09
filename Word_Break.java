// Time Complexity -> O(n^3)
// Space Complexity -> O(o^2)
class Solution {
    HashMap<String, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }

    private boolean helper(String s, HashSet<String> set){
        //base case
        if(0 == s.length()) return true;
        if(map.containsKey(s)) return map.get(s);
        //logic
        for(int i = 0; i < s.length(); i++){
            String subS = s.substring(0, i+1);
            if(set.contains(subS) && helper(s.substring(i+1), set)){
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }
}
