# O(n^2)

import sys

n = int(sys.stdin.readline().strip())

dp = [0] * (n + 1)

if n >= 2:
    dp[2] = 3
    for i in range(4, n + 1, 2):
        if i % 2 == 0:
            dp[i] = dp[i - 2] * dp[2] + 2 + sum(dp[:i - 2]) * 2
    print(dp[n])
else:
    print(0)
