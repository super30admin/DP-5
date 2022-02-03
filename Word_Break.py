from collections import Counter
class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        """
        Word Break
        Time Complexity : O()
        """
        
        wordDict = set(wordDict)
        wordDict = Counter(wordDict)
        q = deque()
        visited = set()
        
        q.append(0)
        while q:
            start = q.popleft()
            if start in visited:
                continue
            
            for end in range(start+1,len(s)+1):
                if wordDict.get(s[start:end]) is not None:
                    if end == len(s):
                        return True
                    q.append(end)
            visited.add(start)
        return False
                    
            