class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        if(s.length() == 0) return true;
        
        int min = Integer.MAX_VALUE;
        for(String str: wordDict){
            set.add(str);
            if(str.length() < min)
                min = str.length();
        }
        
        int i = 0;
        while(i<s.length()){
            int j = i+min;
            while(j<=s.length()){
                if(set.contains(s.substring(i,j))){
                    i = j;
                    break;
                }
                j++;
            }
            if(j>s.length())
                return false;
        }
        return true;
    
    }
}
