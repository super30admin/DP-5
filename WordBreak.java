//Time Complexity : Exponential
//Space:O(recursion depth)
class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        return helper(s);
        
    }
    
    private boolean helper(String curr){
        //base
        if(curr.length()==0)
            return true;
        
        //logic
        for(int i=0;i<curr.length();i++){
            String sub= curr.substring(0,i+1);
            if(set.contains(sub) && helper(curr.substring(i+1))){
                return true;
            }
        }
        return false;
    }
}
//Time Complexity:O(n3)
//Space Complexity:O(n)
class Solution {
    HashSet<String> set;
    public boolean wordBreak(String s, List<String> wordDict) {
        set= new HashSet<>(wordDict);
        boolean dp[]=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<=i;j++){
                if(dp[j] && set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
