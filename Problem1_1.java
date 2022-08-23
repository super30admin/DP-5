//Time Complexity: O(2^n); where n is the length of the string
//Space Complexity: O(m) + O(n); where m is the size of wordDict.
//Code run successfully on LeetCode.

public class Problem1_1 {

    HashSet<String> set;
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        if(wordDict == null|| wordDict.size() == 0)
            return false;
        
        else if(s == null|| s.length() == 0)
            return false;
        
        set = new HashSet<>(wordDict);
        return helper(s);
    }
    
    private boolean helper(String s)
    {
        if(s.length() == 0)
            return true;
        
        for(int i = 0; i < s.length(); i++)
        {
                if(set.contains(s.substring(0,i+1)) && helper(s.substring(i+1)))
                    return true;
        }
        return false;
    }
}
