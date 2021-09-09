"""
TC: O(n^3)
SC: O(n)
"""
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        
        if not s:
            return 0
        #DP solution....
        
        wordDict = set(wordDict)
        result = [0]*len(s)
        result[0] = 1
        result.append(0)
        for i in range(1,len(s)+1):
            for j in range(i):
                if result[j] and s[j:i] in wordDict:
                    result[i] = 1
                    break
        print(result)
        return result[len(s)]
        
        '''
        #BFS solution...
        wordDict = set(wordDict)
        visited = [0] * len(s)
        q = [0]
        while q:
            start = q.pop(0)
            if visited[start] == 0:
                for end in range(start+1,len(s)+1):
                    print(s[start:end])
                    if s[start:end] in wordDict:
                        q.append(end)
                        if end == len(s):
                            return True
                    print(q,visited,start,end)
                visited[start] = 1
        return False
        '''
        '''
        wordDict = set(wordDict)
        q = [0]
        visited = [0]*len(s)
        while q:
            start = q.pop(0)
            if visited[start] == 0:
                visited[start] = 1
                for end in range(start+1,len(s)+1):
                    char = s[start:end]
                    if char in wordDict:
                        q.append(end)
                        if end == len(s):
                            return 1
        return 0
        '''
                        
                        
                
            
                        
        
        