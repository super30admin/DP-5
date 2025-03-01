# tc O(n * dictlen * wl), sc O(n).
dp = [False] * len(s)
for i in range(len(s)):
    for word in wordDict:
        # Handle out of bounds case
        if i < len(word) - 1:
            continue

        if i == len(word) - 1 or dp[i - len(word)]:
            if s[i - len(word) + 1 : i + 1] == word:
                dp[i] = True
                break

return dp[-1]