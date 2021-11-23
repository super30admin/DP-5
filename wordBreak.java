//Time complexity:- O(N^3) N^2 FOR DP AND AND ANOTHER N FOR SUBSTRING.
//Space complexity:-O(n+m).
//Did it run on leetcode?:- Yes.
//Your code with approach:- splitting letter by letter and checking whether valid on both sides which involves dp approach.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] cache=new boolean[s.length()+1];
        HashSet<String> dictionary=new HashSet<>(wordDict);
        cache[0]=true;
        for(int i=0;i<cache.length;i++){
            for(int j=0;j<i;j++){
                if(cache[j] && dictionary.contains(s.substring(j,i))){
                    cache[i]=true;
                    break;
                }
            }
        }
        return cache[cache.length-1];
    }
}