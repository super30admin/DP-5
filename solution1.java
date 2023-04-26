//Time Complexity: O(ml + l^3) m is size of wordDict and l is the lenght of the s
//Space Complexity: O(l^2) : In worst case we will have to store all possible substrings in our hashmap

class Solution1 {
    public HashSet<String> set;
    public HashMap<String, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set = new HashSet<>(wordDict);
        this.map = new HashMap<>();
        return helper(s);
    }

    public boolean helper(String s) {
        //base case
        if( s.length() == 0 ) {
            return true;
        }
        //logic
        for(int i = 0; i < s.length(); i++) {
            String sub = s.substring(0, i+1);
            if( set.contains(sub)) {
                if( !map.containsKey(s.substring(i+1))) {
                    boolean bool = helper(s.substring(i+1));
                    map.put(s.substring(i+1), bool);
                }
                boolean inter = map.get(s.substring(i+1));
                if(inter) {
                    return true;
                }
                // return true;
            }
        }
        return false;
    }
}