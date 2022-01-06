package sol;
import java.util.*;
public class WordBreak {
	public boolean helper(String s, int index,HashSet<String>hs,int dp[]){
	    
	    if(index==s.length()){return true;}
	    boolean x=false;
	    
	    if(dp[index]!=0){
	        
	        if(dp[index]==1){return true;}
	        if(dp[index]==-1){return false;}
	    }
	    
	    for( int i=index+1; i<=s.length();i++)

	    { //System.out.println(s.substring(index,i)+" "+i+" "+index);
	        if(hs.contains(s.substring(index,i))){
	           
	            x = helper(s,i,hs,dp);
	            if(x){
	                dp[index]=1;
	                return x;}
	        }
	    
	    }
	    dp[index]=-1;
	    return false;
	}    
	    
	    
	    HashSet<String>hs= new HashSet<>();
	    public boolean wordBreak(String s, List<String> wordDict) {
	        
	        for(String s1:wordDict){
	            
	            hs.add(s1);
	            
	        }
	        
	        int []dp=new int[s.length()];
	        
	        return helper(s,0,hs,dp);
	       
	        
	        
	        
	    }
}
