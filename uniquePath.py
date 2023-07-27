class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        @cache
        def helper(r, c):
            # base
            if r == m-1 and c == n-1:
                return 1
            if r == m or c == n:
                return 0

            # logic
            case1 = helper(r + 1, c)
            case2 = helper(r, c + 1)
            return case1 + case2

        
        return helper(0,0)
    
        


           
        

