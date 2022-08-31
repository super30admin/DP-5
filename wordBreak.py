
#Time Complexity: O(N^N)
#Space Complexity: O(num of possible paritions(len(s))
#backtracking

def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    if not s:
        return True

    return self.helper(s, wordDict, 0)


def helper(self, s, wordDict, currIdx):
    # base
    if not s or currIdx == len(s):
        return True

    # logic
    for idx in range(currIdx, len(s)):
        subString = s[currIdx:idx + 1]
        if subString in wordDict and self.helper(s, wordDict, idx + 1):
            return True
    return False

#Time Complexity: O(N^3) #substringMatching
#Space Complexity: O(N)
def wordBreak(self, s: str, wordDict: List[str]) -> bool:
    if not s:
        return True
    dp = [False] * (len(s) + 1)
    dp[0] = True
    wordSet = set()
    for word in wordDict:
        wordSet.add(word)

    for idx in range(1, len(s) + 1):
        for j in range(idx):
            if dp[j] and s[j:idx] in wordSet:
                dp[idx] = True
                break
    return dp[-1]