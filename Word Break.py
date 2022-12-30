import numpy as np
class Solution:

    # DP
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        a = np.zeros(len(s) + 1, dtype=bool)

        a[0] = True 
        

        for i in range(1, len(s)+1):
            for j in range(0, len(s)+1):
                if j == i:
                    break
                if not a[j]:
                    continue
                if s[j:i] in wordDict:
                    a[i] = True
                    break
                else:
                    continue

        return a[len(s)]
