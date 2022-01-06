package sol;

import java.util.*;
public class UniquePaths {

	 public int helper(int x, int y, int m, int n, HashMap<String,Integer>hm){
		    
	        
	        if(x>=m||y>=n||x<0||y<0){return 0;}
	        if(x==m-1&&y==n-1){return 1;}
	        
	        if(hm.containsKey(x+"*"+y)){return hm.get(x+"*"+y);}
	        
	         hm.put(x+"*"+y,(helper(x+1,y,m,n,hm))+helper(x,y+1,m,n,hm));
	        
	        
	        return hm.get(x+"*"+y);
	    }
	    
	    
	    public int uniquePaths(int m, int n) {
	     HashMap<String,Integer>hm= new HashMap<>();
	        return helper(0,0,m,n,hm);
	        
	        
	    }
	
	
}
