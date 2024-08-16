def wordBreak(s, wordDict):
    n = len(s)
    dp = [False] * (n + 1)
    dp[0] = True  # Base case
    #print(dp)
    
    word_set = set(wordDict)
    #print(word_set)  # To allow O(1) lookups
    
    for i in range(1, n + 1):
        for j in range(i):
            if dp[j] and s[j:i] in word_set:
                print(s[j:i])
                dp[i] = True
                break
    print(dp)
    return dp[n]

# Example usage:

s = "leetcode"
wordDict = ["leet", "code"]
print(wordBreak(s, wordDict))  # Output: True

#time = 𝑂(𝑛^2)
#space = O(n)