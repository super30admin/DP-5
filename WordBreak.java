/**
 * Time Complexity :  O(n^2 + m) where n is the length of the string and m is the number of words in dictionary
 * Space Complexity : O(n) where n is the length of the string
 */
import java.util.*;
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null){return false;}
        HashSet<String> set = new HashSet<>(wordDict);                                      
        boolean[] dp =  new boolean[s.length()+1];
        dp[0] = true;                                                                               
        int j = 0;
        for(int i = 1; i < dp.length; i++)
        {   j = 0;
            while(j < i){                                                                       
            if(dp[j] && set.contains(s.substring(j, i))){                                        
                dp[i] = true;                                                                   
                break;
            } 
                j++;                                                                            
            }
        }
        return dp[dp.length-1];                                                                 
    }
}