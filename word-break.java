//Time complexity: O(2^N)
//Space complexity: O(N)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0) {
            return true;
        }
        Set<String> set = new HashSet<>(wordDict);
        return helperMethod(s, set); 
        
    }
    private boolean helperMethod(String s, Set<String> set) {
        //base
        if(s.length() == 0) {
            return true;
        }
        //logic
        for(int i = 0; i < s.length(); i++) {
            if(set.contains(s.substring(0, i+1)) && helperMethod(s.substring(i+1), set)) {
                return true;
            }
        }
        return false;
    }
}