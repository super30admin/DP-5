class TopDownSolution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        word_set = set(wordDict)

        memo = [None] * len(s)

        if s in word_set:
            return True

        def recurse(pivot):
            if pivot == len(s):
                return True
            if memo[pivot] != None:
                return memo[pivot]
            
            res = False
            for i in range(pivot, len(s)):
                if i == pivot:
                    cur_str = s[pivot]
                else:
                    cur_str = cur_str + s[i]
                if cur_str in word_set:
                    if recurse(i+1):
                        res = True
                        break
            
            memo[pivot] = res
            return memo[pivot]
        
        return recurse(0)