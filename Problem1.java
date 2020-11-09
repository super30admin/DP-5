class Solution 
{
  private String s;
  private List<String> wordDict;
  private boolean[] arr;
  private int n;
  
  public boolean wordBreak(String s, List<String> wordDict) 
  {
    this.s = s;
    this.wordDict = wordDict;
    
    n = s.length();
    arr = new boolean[n+1];
    
    return solve(0);
  }
  
  private boolean solve(int start)
  {
    if (start == n) return true;
    
    for (String word : wordDict)
    {
      if (s.startsWith(word, start))
      {
        int len = start + word.length();
        if (!arr[len])
        {
          if (solve(len)) return true;
          arr[len] = true;
        }
      }
    }
	
    return false;
  }
}