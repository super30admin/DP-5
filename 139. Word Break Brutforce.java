class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
 
        HashSet<String> dict = new HashSet<>();
        for(int i = 0; i < wordDict.size(); ++i){
            dict.add(wordDict.get(i));
        }
        return helper(s,dict);  
    }
    
    public boolean helper(String s, HashSet<String> dict){
               // System.out.println("helper");
               // System.out.println("*");    
                // System.out.println("for "+ s);
        for(int i = 0; i < s.length();++i){
            for(int j = 0; j <= s.length();++j){
                
                String tempString = s.substring(0,j);
                if(dict.contains(tempString)){
                    //recur on rest
                    //System.out.println("match");
                    //System.out.println(tempString);
                    if(j == s.length())
                    {
                        //System.out.println("returning true for "+s);
                        dict.add(tempString);
                        return true;
                    }                  
                    String temp2 = s.substring(j,s.length()); 
                      //System.out.println(" temp2");
                      //System.out.println(temp2);
                    if(dict.contains(temp2))
                        return true;
                    if(helper(temp2,dict))
                      {
                        dict.add(temp2);
                       // System.out.println("returning true for "+s);
                        return true;
                    }                  
        
                        
                }
            }     
            
        }
             
        if(dict.contains(s))
            return true;
   
        // System.out.println("returning False for"+s);
                        return false;
                               
              
    }
}
