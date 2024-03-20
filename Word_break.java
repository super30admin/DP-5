class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean []array = new boolean[s.length()+1];
        HashSet<String> set = new HashSet<>(wordDict);
        array[0] = true;
        for(int i=1; i<=s.length();i++) {
            for(int j =0; j<i;j++) {
                if(array[j] == true && set.contains(s.substring(j,i))) {
                    array[i] = true;
                }
            }
        }
        return array[s.length()];
    }
}