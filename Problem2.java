// time: O(m*l+l^3)
// space : O(n)


class Solution {
    Map<String,Boolean> memoMap;
    public boolean wordBreak(String s, List<String> wordDict) {
        memoMap = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);

        return recur(s, set);
    }

    private boolean recur(String s, Set<String> set){
        if(s.length() ==0 ){
            return true;
        }

        for(int i = 1; i<=s.length(); i++){
            if(set.contains(s.substring(0,i))){
                if(!memoMap.containsKey(s.substring(i))){
                    boolean res = recur(s.substring(i),set);
                    memoMap.put(s.substring(i),res);
                    if(res) return true;
                }else{
                    if(memoMap.get(s.substring(i)))
                        return true;
                }
            }
        }
        return false;
    }
}