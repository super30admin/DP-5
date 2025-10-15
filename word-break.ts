// Time complexity - O(n*2),n = length of the string 's'
// Space complexity - O(n)
function wordBreak(s: string, wordDict: string[]): boolean {
	const n = s.length;
	const set = new Set(wordDict);
	const dp = new Array(n + 1).fill(false);

	dp[0] = true;
	for (let i = 1; i < dp.length; i++) {
		// iterate through 0..i with prefix j to split it into 2 substring 0..j-1 and j..i
		for (let j = 0; j < i; j++) {
			// if dp[j] is true means first part is already breakable into words
			// and second sibstring is part of dictonary
			// meaning 0..i-1 is breakable into words and set dp[i] to true
			if (dp[j] && set.has(s.substring(j, i))) {
				dp[i] = true;
				// break the loop early
				break;
			}
		}
	}

	return dp[n];
}
