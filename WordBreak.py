"""
Rasika Sasturkar
Time complexity: O(n^3)
Space complexity: O(n+m*l)
"""


def wordBreak(s: str, wordDict) -> bool:
    hashset = set(wordDict)
    dp = [False for _ in range(len(s) + 1)]
    dp[0] = True
    for i in range(len(dp)):
        for j in range(i):
            if dp[j] and s[j:i] in hashset:
                dp[i] = True
                break
    return dp[len(s)]


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(wordBreak(s="leetcode", wordDict=["leet", "code"]))  # returns True
    print(wordBreak(s="applepenapple", wordDict=["apple", "pen"]))  # returns True
    print(wordBreak(s="catsandog", wordDict=["cats", "dog", "sand", "and", "cat"]))  # returns False


if __name__ == "__main__":
    main()
