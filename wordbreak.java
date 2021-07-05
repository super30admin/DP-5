//Time Complexity:O(N) where N is the length of the string
//Space Complexity:O(N)
//Approach: Add the elements of the dictionary into the set. Then increase the window from 0 to i for every value of i and check if the substring in the window is present in the set and mark the corresponding index i in the flag array to be equal to true. If all the space separated substrings of s are present in the dictionary, then the last element of the flag array will indicate true, else false. 
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] flag=new boolean[s.length()+1];
        Set<String> set=new HashSet<>();
        for(String a:wordDict){
            set.add(a);
        }
        flag[0]=true;
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(flag[j]&&set.contains(s.substring(j,i))){
                    flag[i]=true;
                    break;
                }
            }
        }
        return flag[s.length()];
       
        
    }
}