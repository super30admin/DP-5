class Solution {
    //tc-exponential
    
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s,set);

    }
    private boolean helper(String s, HashSet<String> set)
    {
        //base case
        if(s.length() == 0) return true;
        //logic
        for(int i=0;i<s.length();i++)
        {
            String sub = s.substring(0,i+1);

            if(set.contains(sub) && helper(s.substring(i+1), set))
            {
            return true;
            }
        }
        return false;

    }
}