# O(n)

import sys


def go(n, arr):
    dp = [[0] * n for _ in range(2)]
    dp[0][0] = arr[0]
    dp[1][0] = -1000
    for i in range(1, n):
        dp[0][i] = max(dp[0][i - 1] + arr[i], arr[i])
        dp[1][i] = max(dp[0][i - 1], dp[1][i - 1] + arr[i])
    return max(max(dp[0]), max(dp[1]))


n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split(" ")))
print(go(n, arr))
