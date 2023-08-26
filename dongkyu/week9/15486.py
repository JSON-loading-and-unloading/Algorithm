import sys


def solve(n, tp):
    tp = [(0, 0)] + tp
    dp = [0] * (n + 1)
    for i in range(1, n + 1):
        dp[i] = max(dp[i], dp[i - 1])
        idx = i + tp[i][0] - 1
        if i + tp[i][0] - 1 <= n:
            dp[idx] = max(dp[idx], dp[i - 1] + tp[i][1])
    return max(dp)


n = int(sys.stdin.readline())
tp = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(n)]
print(solve(n, tp))
