# TC: O(N!) since for every character we will be recusing with string of length N-1 operations. 
# SC: O(H) where H is the height of the recursive stack.
  
  def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        def recurse(string): 
#             base
            if len(string) == 0 or not string: 
                return True
#             logic
            for i in range(len(string)):
                if string[0:i + 1] in wordDict and recurse(string[i+ 1:]): 
                    return True
            return False
        
        return recurse(s)
