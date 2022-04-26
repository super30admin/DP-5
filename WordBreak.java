import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//Time Complexity : O(n^3)
//Space Complexity : O(m+n); where m = number of words in dictionary; and n= string length
public class WordBreak {	
	/**Approach: DP**/
	public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set= new HashSet<>(wordDict);
        boolean[] dp= new boolean[s.length()+1];
        dp[0]= true;
        for(int i=1; i<dp.length; i++){//O(n)            
            for(int j=0; j<i; j++){//O(n)
                String substr= s.substring(j, i);//O(n)
                if(dp[j] && set.contains(substr)){                
                    dp[i]= true;  
                    break;
                }
            }
        }
        return dp[s.length()];
    }
	
	
	// Driver code to test above
	public static void main (String[] args) {
		WordBreak ob= new WordBreak();
		String s= "leetcode";
		List<String> wordDict= new ArrayList<>(Arrays.asList("leet","code"));
			
		System.out.print("Can '"+s+"' be segmented into one or more dictionary words: "+ob.wordBreak(s,wordDict));	
	}
}
