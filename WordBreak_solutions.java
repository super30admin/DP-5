package Stringscodes;

import java.util.HashSet;
import java.util.List;

public class WordBreak_solutions {
	
	private static HashSet<String> set;
	
	
	public static boolean wordBreak_dp(String s , List<String> worddict) {
		if(s==null||s.length()==0)return false;
		 
		set = new HashSet<>(worddict);
		boolean [] dp=new boolean[s.length()+1];
		
		dp[0]=true;
		
		
		
		for(int i=1;i<dp.length;i++) {
			for(int j=0;j<i;j++) {
				if(dp[j]==true&&set.contains(s.substring(j,i))) {
					dp[i]=true;
					break;
				}
				
				
				
			}
		}
		
		
		return dp[dp.length-1];
		
		
	
	}
	
	
	

	
	
	public static boolean wordBreak_brute(String s , List<String> worddict) {
		if(s==null||s.length()==0)return false;
		
		 set = new HashSet<>(worddict);
		
		
		return helper(s);
		
	
	}
	
	
	public  static  boolean helper(String s) {
		
		
		// base 
		if(s.length()==0)return true;
		
		
		// logic
		for(int i=0;i<s.length();i++) {
			//split into every substring and try the combinations
			
			if(set.contains(s.substring(0,i+1))&&helper(s.substring(i+1))) {
				return true;
			}
		}
		return false;
		
		
		
	}
}
