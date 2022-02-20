class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        '''
        -> Iterate over the elements in the string,
            for each element we check if the stbstring until it's previous index is in the dictionary. 
            if it is valid we make it's dp[idx] = 1 else dp[idx] = 0 
            eg: A B C D E F G
                1 0 1 0 1 curr pointer 
                say we are at F, we check if 
                1. A to E is valid 
                2. C to E is valid 
                if either one is valid, we mark F as 1 else mark F as 0 
                finally return the last element in the dp array and see if it is 1. 
                If it is 1 -> True, else False. 
            Time Complexity = O(N**2)
            Space Complexity = O(N)
                
        '''
        len_s = len(s)
        dp = [0]*( len_s +1)
        # print(dp)
        dp[0] = 1
        for i in range( len_s +1):
            for j in range(0, i):
                if dp[j] == 1 and s[j:i] in wordDict:
                        dp[i] = 1
        return dp[-1] == 1 
         
    def BruteForcewordBreak(self, s: str, wordDict: List[str]) -> bool:
        def wordBreakRecur(s: str, word_dict: Set[str], start: int):
            if start == len(s):
                return True
            for end in range(start + 1, len(s) + 1):
                if s[start:end] in word_dict and wordBreakRecur(s, word_dict, end):
                    return True
            return False

        return wordBreakRecur(s, set(wordDict), 0)
