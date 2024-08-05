//Time complexity : O(m*n*K)
//Space Complexity : O(n)
class Solution {
    HashMap<String, Boolean> map;
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.map = new HashMap<>();
        this.set = new HashSet<>(wordDict);

        return helper(s,0);
    }

    private boolean helper(String s, int pivot) {
        //base case
        if(pivot == s.length()) return true;

        //logic
        for(int i = pivot; i < s.length(); i++) {
            String subStr = s.substring(pivot,i+1);
            if(set.contains(subStr)) {
                String remStr = s.substring(i+1);
                if(!map.containsKey(remStr)) {
                    map.put(remStr, helper(s,i+1));
                }
                if(map.get(remStr)) {
                    return true;
                }
            }
        }
        return false;
    }
}