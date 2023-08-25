import sys


def solve(first, second):
    n = len(second)
    m = len(first)
    dp = [[''] * m for _ in range(n)]

    for i in range(1, n):
        for j in range(1, m):
            if first[j] == second[i]:
                dp[i][j] = dp[i - 1][j - 1] + first[j]
            else:
                if len(dp[i - 1][j]) > len(dp[i][j - 1]):
                    dp[i][j] = dp[i - 1][j]
                else:
                    dp[i][j] = dp[i][j - 1]
    return dp[n - 1][m - 1]


first = [' '] + list(map(str, sys.stdin.readline()))
second = [' '] + list(map(str, sys.stdin.readline()))
lcs = solve(first, second)
print(len(lcs) - 1)
if len(lcs) > 0:
    print(lcs)
