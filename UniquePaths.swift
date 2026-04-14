//
//  UniquePaths.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 2/21/26.
//

class UniquePaths {
    func uniquePaths(_ m: Int, _ n: Int) -> Int {
        
        var dp = Array(repeating: Array(repeating: 0, count: n), count: m)
        
        //fill the last row with 1
        for i in stride(from: m - 1, through: 0, by: -1) {
            for j in stride(from: n - 1, through: 0, by: -1) {
                if (i == m - 1) {
                    dp[i][j] = 1
                    continue
                }
                if (j == n - 1) {
                    dp[i][j] = 1
                    continue
                }
                dp[i][j] = dp[i][j+1] + dp[i+1][j]
            }
        }
        return dp[0][0]
    }
    
    //MARK: Using 1-D DP array
    func uniquePathsWithSingleDPArray(_ m: Int, _ n: Int) -> Int {
        var dp = Array(repeating: 0, count: n)
        
        //fill the last row with 1
        for i in stride(from: m - 1, through: 0, by: -1) {
            for j in stride(from: n - 1, through: 0, by: -1) {
                if (i == m - 1) {
                    dp[j] = 1
                    continue
                }
                if (j == n - 1) {
                    dp[j] = 1
                    continue
                }
                dp[j] = dp[j+1] + dp[j]
            }
        }
        return dp[0]
    }
    
    //MARK: Using memoization
    
    func uniquePathsUsingMemoization(_ m: Int, _ n: Int) -> Int {
        var memo = Array(repeating: Array(repeating: -1, count: n), count: m)
        let noOfPaths = findUniquePathsRecursive(i: 0, j: 0, m: m, n: n, memo: &memo)
        print("no of paths \(noOfPaths)")
        return noOfPaths
    }
    
    func findUniquePathsRecursive(i: Int, j: Int, m: Int, n: Int, memo: inout [[Int]]) -> Int {
        //base
        if (i == m - 1 || j == n - 1) {
            return 1
        }
        if (memo[i][j] != -1) {
            return memo[i][j]
        }
        let pathsFromRight = findUniquePathsRecursive(i: i, j: j + 1, m: m, n: n, memo: &memo)
        let pathsFromDown = findUniquePathsRecursive(i: i + 1, j: j, m: m, n: n, memo: &memo)
        memo[i][j] = pathsFromDown + pathsFromRight
        return pathsFromRight + pathsFromDown
    }
}
