class Solution {
    public boolean wordBreak(String s, List<String> dict) {
        //fast lookup
        HashSet<String> set = new HashSet<>();
        
        for(String word : dict){
            set.add(word);
        }
        
        boolean[] isValid = new boolean[s.length()+1];
        isValid[0] = true;//base
        
        for(int i = 0; i < s.length() ; i++){
            int j = i;
            while(j>=0){
                if(set.contains(s.substring(j,i+1)) && isValid[j]){
                    isValid[i+1] = true;
                    break;
                }
                j--;
            }
        }
            return isValid[s.length()];
    }
}