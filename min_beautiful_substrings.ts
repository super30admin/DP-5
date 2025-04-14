function minimumBeautifulSubstrings(s: string): number {
  // Helper function to check if a string is a valid power of 5
  const isPowerOfFive = (binary: string): boolean => {
    if (binary[0] === "0") return false; // Leading zero is invalid
    let decimal = parseInt(binary, 2); // Convert binary string to decimal
    if (decimal === 0) return false; // 0 is not a power of 5

    // Check if the number is a power of 5
    while (decimal > 1) {
      if (decimal % 5 !== 0) return false;
      decimal = Math.floor(decimal / 5);
    }
    return true;
  };

  const n = s.length;
  const dp = Array(n + 1).fill(Infinity);
  dp[0] = 0; // Base case: no partitions needed for an empty string

  for (let i = 1; i <= n; i++) {
    for (let j = 0; j < i; j++) {
      const substring = s.slice(j, i);
      console.log(
        " Str: " + substring + " is Power of 5 = " + isPowerOfFive(substring)
      );
      if (isPowerOfFive(substring)) {
        dp[i] = Math.min(dp[i], dp[j] + 1);
      }
    }
  }

  return dp[n] === Infinity ? -1 : dp[n];
}

describe("2767. Partition String Into Minimum Beautiful Substrings", () => {
  it("Basic", () => {
    expect(minimumBeautifulSubstrings("1011")).toStrictEqual(2);
  });
});
