// Time Complexity : O(N^2)
// Space Complexity : O(N) space of the array. 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
     HashSet<String> set=new HashSet<String>();
        for(String word:wordDict){
            set.add(word);
        }
     
        s="^"+s;
        
        boolean[] b=new boolean[s.length()];
         b[0]=true;
        
        for(int i=1;i<s.length();i++){
           //int k=i;
           for(int j=1;j<=i;j++){
                String check=s.substring(j,i+1);
            if(set.contains(check) && b[j-1]){
                b[i]=true;
                break;
            }
               // k--;
            }
            }
         return b[s.length()-1];
        }
       
       
    }
