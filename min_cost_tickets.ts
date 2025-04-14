function minCostTickets(days: number[], costs: number[]): number {
  const travelDays = new Set(days);
  const lastDay = days[days.length - 1];
  const dp: number[] = new Array(lastDay + 1).fill(0);

  for (let i = 1; i <= lastDay; i++) {
    if (!travelDays.has(i)) {
      dp[i] = dp[i - 1];
    } else {
      dp[i] = Math.min(
        dp[i - 1] + costs[0],
        dp[Math.max(0, i - 7)] + costs[1],
        dp[Math.max(0, i - 30)] + costs[2]
      );
    }
  }

  return dp[lastDay];
}

function minCostTickets_with_pivot(days: number[], costs: number[]): number {
  const durations = [1, 7, 30];

  function dfs(day: number): number {
    if (day == days.length) {
      return 0;
    } 

    let result = Number.MAX_SAFE_INTEGER;

    for (let i = 0; i < costs.length; i++) {
      let duration = durations[i];
      let cost = costs[i];
      let nextDay = day;
      let currentDay = days[day];
      while (nextDay < days.length && days[nextDay] < currentDay + duration) {
        nextDay += 1;
      }
      result = Math.min(result, cost + dfs(nextDay));
    }
    return result;
  }

  return dfs(0);
}

describe("983. Minimum Cost For Tickets", () => {
  it("Basic", () => {
    expect(minCostTickets([1, 4, 6, 7, 8, 20], [2, 7, 15])).toStrictEqual(11);
  });

  it("Recursion Logic", () => {
    expect(
      minCostTickets_with_pivot([1, 4, 6, 7, 8, 20], [2, 7, 15])
    ).toStrictEqual(11);
  });
});
