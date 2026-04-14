//
//  WordBreak.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/21/26.
//

class WordBreak {
    
    init() {
        wordBreak("catsandog", ["cats","dog","sand","and","cat"])
    }
    
    func wordBreak(_ s: String, _ wordDict: [String]) -> Bool {
        let isValid = helper(s: s, wordDict: wordDict, pivot: 0)
        return isValid
    }
    
    //O(2^n) *n time complexity, *n to check the presence of the string in the set
    func helper(s: String, wordDict: [String], pivot: Int) -> Bool {
        //base
        if (s.count == pivot) {
            return true
        }
        for end in pivot..<s.count {
            let sIdx = s.index(s.startIndex, offsetBy: pivot)
            let endIdx = s.index(s.startIndex, offsetBy: end)
            let subStr = s[sIdx...endIdx]
            
            if (wordDict.contains(String(subStr))) {
                if (helper(s: s, wordDict: wordDict, pivot: end + 1)) {
                    return true
                }
            }
        }
        return false
    }
    
    /*
     Take a set for memoizing the strings which we are not able to split.
     */
    
    func wordBreakUsingMemoization(_ s: String, _ wordDict: [String]) -> Bool {
        var notValidStrs = Set<String>()
        return helperUsingMemo(s: s, wordDict: Set<String>(wordDict), pivot: 0, notValidStrs: &notValidStrs)
    }
    
    func helperUsingMemo(s: String, wordDict: Set<String>, pivot: Int, notValidStrs: inout Set<String>) -> Bool {
        //base
        if (s.count == pivot) {
            return true
        }
        
        let sIdx = s.index(s.startIndex, offsetBy: pivot)
        let endIdx = s.index(s.startIndex, offsetBy: s.count - 1)
        
        if (notValidStrs.contains(String(s[sIdx...endIdx]))) {
            return false
        }
        
        for end in pivot..<s.count {
            let sIdx = s.index(s.startIndex, offsetBy: pivot)
            let endIdx = s.index(s.startIndex, offsetBy: end)
            let subStr = s[sIdx...endIdx]
            
            if (wordDict.contains(String(subStr))) {
                if (helperUsingMemo(s: s, wordDict: wordDict, pivot: end + 1, notValidStrs: &notValidStrs)) {
                    return true
                }
            }
        }
        
        notValidStrs.insert(String(s[sIdx...endIdx]))
        return false
    }
    
    //MARK: Using DP
    func wordBreakUsing1DimensionalDPArray(_ s: String, _ wordDict: [String]) -> Bool {
        
        //Using DP. In DP, at a particular index, we will store if the string up till that level can be split into valid splits or not. When next character comes up then it can use the saved information for previous indices.
        let wordDict = Set<String>(wordDict)
        var dp = Array(repeating: false, count: s.count + 1)
        dp[0] = true
        var sArray = Array(s)
        
        for i in 1..<dp.count {
            for j in 0..<i {
                if (dp[j] && wordDict.contains(String(sArray[j..<i]))) {
                    dp[i] = true
                    break
                }
            }
        }
        return dp[s.count]
    }
}
