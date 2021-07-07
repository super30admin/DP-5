// Time Complexity :O(N^2)
// Space Complexity :O(N+1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Store all dictionary words into a hashset. Have a boolean array of length equals to string length plus 1 .Since an empty string 
//    is always present in a dictionary make array[0] as true.Take a pointers start at 0.
// 2. Now for index 1 to end of array check if each substring of given string from (start,current index) is present in set. If it is 
//    present make current index as true . Else increment start pointer till current index and repeat above process . Do this till end of array.
// 3. Now , if array's last element is true it means string can be formed by words in dictionary and return true.Else false. 
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class wordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1;i<=s.length();i++){
            int j = 0;
            while(j<i){
                if(dp[j] && set.contains(s.substring(j,i))) dp[i] = true;
                j++;
            }
        }
        return dp[s.length()];
    }
    
    //recursive solution
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s,set);
    }
    public boolean helper(String s,HashSet<String> set){
        if(s.length() == 0) return true;
        for(int i = 1;i<=s.length();i++){
            if(set.contains(s.substring(0,i)) && helper(s.substring(i,s.length()),set))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "aaaaaaa";
//        List<String> word = new ArrayList<>()
//        {{add("leet");
//        add("code");}};
        List<String> word = new ArrayList<>();
        word.add("aaa");
        word.add("aaaa");
        System.out.println(wordBreak(s,word));
    }
}
