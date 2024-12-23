import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
// Time Complexity: 0(n^2)
// Space Complexity: O(n^2)
public class problem1 {
HashSet<String> set;
HashMap<String, Boolean> memoMap;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.set=   new HashSet<>(wordDict);
        memoMap= new HashMap<>();
        return helper(s,0);
    }
    public boolean helper(String s, int pivot) {
        if (pivot==s.length())
        {
            return true;
        }
        String str= s.substring(pivot);
        if (memoMap.containsKey(str))
        {
            return memoMap.get(str);
        }
        for (int i=pivot;i<s.length();i++)
        {
            String subStr= s.substring(pivot,i+1);
            if (set.contains(subStr) && helper(s,i+1))
            {
                return true;
            }
        }
        memoMap.put(str,false);
        return false;
    }
}
