'''
139 Word Break
https://leetcode.com/problems/word-break/description/

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:
Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:
Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:
Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

Constraints:
1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.

Solution:
1. Recursion
https://youtu.be/St-WLFHcRzw?t=2142
Time: O(2^N)  Space:  O(N)

2. DP
Create an empty array of len N+1 to store dp values.
dp[i] = 1 if string[0:i] = string[0...i-1] is breakable/partitioned
      = 0, otherwise
Eg. if s = 'leetcode' and dp[4] = True, it means "leet" is breakable.
index 0 1 2 3 4 5 6 7
char  l e e t c o d e
Thus, dp[i] = prefix in the string (prior to current index i) is breakabale

Initialize, dp[0] = 1 (since string[0:0] = "" (empty string) = nothing to break)
dp[i] = 1 if for any j in 0:i-1, dp[j] == 1 and s[j:i] in h

dp[j] = 1 means prefix = s[0:j] is breakable
s[j:i] in h means suffix = s[j:i] is present in dictionary

We iterative fill dp[i] for each i = 1,...,N
if dp[N] = True (s[0:N] = s[0...N-1] is breakable)
         = False (s[0...N-1] is not breakable)
https://youtu.be/St-WLFHcRzw?t=3207
Time: O(N^3)  Space:  O(MK + N) (M = words in dict, K = avg len of words in dict, N = length of dp array)

Note: If we treat the creation of a copy of the suffix (using the following statement) as O(1), then time complexity = O(N^2)
suffix = s[j:i]
'''
from typing import List

def wordBreak_recursion(s: str, wordDict: List[str]) -> bool:
    def recurse(s, index):
        if index == N:
            return True
        found = False
        for i in range(index, N):
            substring = s[index:i+1]
            if substring in h:
                found = recurse(s, i+1)
                if found:
                    break
        return found

    if not s:
        return True
    if not wordDict:
        return False
    N = len(s)
    h = set()
    for word in wordDict:
        h.add(word)
    return recurse(s, 0)

def wordBreak_dp(s: str, wordDict: List[str]) -> bool:
    if not s:
        return True
    if not wordDict:
        return False
    N = len(s)
    h = set()
    for word in wordDict:
        h.add(word)
    dp = [False]*(N+1)
    dp[0] = True
    for i in range(N+1): # i = last index, iterate i from 1 to N, O(N)
        for j in range(i): # j = start index of suffix, O(N)
            if dp[j] == True: # prefix = s[0...j-1] is breakable
                suffix = s[j:i] # suffix = s[j...i-1], O(N) (copying N chars)
                if suffix in h:
                    dp[i] = True
                    break
            else: # if prefix is not breakable, go to next j
                pass
    return dp[N]

def run_wordBreak():
    tests = [("leetcode", ["leet","code"], True),
             ("leetcode", ["l", "le", "etc", "o", "de"], True),
             ("leetcode", ["l", "le", "etc", "o"], False),
             ("applepenapple", ["apple","pen"], True),
             ("catsandog", ["cats","dog","sand","and","cat"], False),
             ("abcd", ["a","abc","b","cd"], True), # interesting case: enforces looking at all previous segmentable strings instead of the just the last segmentable string. eg. Suppose we have discovered that "abc" is segmentable (since it's in dictionary) and we want to know if 'abcd' is segmentable. We can write 'abcd' = 'abc' (in dict) + 'd'. Since 'd' is not in dictionary, we declare 'abcd' is not segmentable. But this is incorrect. 'abcd' is segmentable if we split 'abcd' = 'ab' (segmentable) + 'cd' (in dict). And, 'ab' is segmentable since 'ab' = 'a' (in dict) + 'b'(in dict)
    ]
    for test in tests:
        s, wordDict, ans = test[0], test[1], test[2]
        print(f"\nString = {s}")
        print(f"Dictionary = {wordDict}")
        for method in ['recursion', 'dp']:
            if method == "recursion":
                breakable = wordBreak_recursion(s, wordDict)
            elif method == "dp":
                breakable = wordBreak_dp(s, wordDict)
            print(f"Method {method}: Is word break possible? {breakable} ")
            success = (ans == breakable)
            print(f"Pass: {success}")
            if not success:
                print("Failed")
                return

run_wordBreak()