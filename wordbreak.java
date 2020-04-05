
# Time complexity:O(n^2)
# Space complexity: 0(1)
# Did code run successfully on leetcode: yes
# Any problem you faced: No








class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();

        for(String word: wordDict){
            set.add(word);
        }


        s = "^" + s;

        boolean[] isValid = new boolean[s.length()];
        isValid[0] = true;


        for(int i = 0; i < s.length(); i++){
            int k = i;
            while(k >= 1){
                if(set.contains(s.substring(k,i+1)) && isValid[k - 1]){
                    isValid[i] = true;
                    break;
                }
                k--;
            }
        }

        return isValid[s.length() - 1];
        }
}