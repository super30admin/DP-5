# Time complexity: O(n^2)
# Space complexity: O(n)

def wordBreak(s, wordDict):
    word_set = set(wordDict)
    dp = [False] * (len(s) + 1)
    dp[0] = True

    for i in range(len(s)):
        if dp[i]:
            for j in range(i + 1, len(s) + 1):
                if s[i:j] in word_set:
                    dp[j] = True

    return dp[-1]
