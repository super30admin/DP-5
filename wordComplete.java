//Time Complexity: o(n^3)
//Space Complexity: o(1)
//Expln: We keep moving on the dp array by storing whether the substring from j to i exist or not if yes store True and 
//Iterate j till it finds true to check whether the other substring from the true location till i exists if its false just keep
//moving forward, The first element is true because there is no previous substring. In this way we will find out if it is a word 
//complete at the end of the dp array. If is partitionable.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        if(s.length() ==0 ) return false;
        boolean[] arr = new boolean[s.length()+1];
        arr[0] = true;
        for(int i =1; i < arr.length; i++)
        {
            for(int j =0; j< i; j++)
            {
                if(arr[j] == true && set.contains(s.substring(j,i)))
                {
                    arr[i] = true;
                    break;
                        
                }
            }
        }
        return arr[arr.length -1];
        
    }
}