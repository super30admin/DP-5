TC:O(n)
SC:O(n)

Leetcode : failed

Approach: map the dictionary, check whether each substring is there in set or not.


class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        
        for( String str: wordDict){
            set.add(str);
        }
        StringBuilder sb = new StringBuilder();
        
        for(char c: s.toCharArray()){
            sb.append(c);
            if(set.contains(sb.toString())){
                sb=new StringBuilder() ;
            }
            // System.out.println(sb.toString());
        }
        System.out.print(" sb tostring"+sb.toString());
        if(sb.length() != 0) return false;
        else return true;
    }
}
