class Solution:
    '''
    Top Down Approach
    With Cache:
    Time Complexity:
    Space Complexity: O(n)
    '''
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        x = set(wordDict)
        o = False
        @cache
        def helper(index):
            if(index==len(s)):
                nonlocal o
                o = True
                return
            for i in range(index,len(s)):
                if(s[index:i+1] in x):
                    if(o==False):
                        helper(i+1)
                    else:
                        return
        
        helper(0)
        return o
