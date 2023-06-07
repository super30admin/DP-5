//Leetcode - 139
//TimeComplexity -O(M*l+l^3)
//SpaceComplexity -O(N)
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordBreak {
    Map<String,Boolean> memoMap;
    public boolean wordBreak(String s, List<String> wordDict) {
        memoMap = new HashMap<>();
        Set<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }

    private boolean helper(String s, Set<String> set){
        if(s.length() ==0 ){
            return true;
        }
        for(int i = 1; i<=s.length(); i++){
            if(set.contains(s.substring(0,i))){
                if(!memoMap.containsKey(s.substring(i))){
                    boolean res = helper(s.substring(i),set);
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
