#As taught in class using DP to solve this problem
#Time Complexity: O(n^3)
# Sapce complexity: O(n) 
def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    if s is None or len(s)==0:
        return False
    hset = list(set(wordDict))
    print(hset)
    dp = list()
    print(dp)
    dp.append(True)
    for i in range(1,len(dp)):
        for j in range(0,i):
            if dp[j] and s[j:i] in hset:
                dp.append(True)
                
                break
    return dp[len(dp)-1]

s = "leetcode"
wordDict = ["leet", "code"]
ss = wordBreak(s,wordDict)
print(ss)