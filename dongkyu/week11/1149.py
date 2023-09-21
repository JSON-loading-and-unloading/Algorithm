import sys


def solve(n, board):
    dp = [[0] * 3 for _ in range(n)]
    for i in range(n):
        for j in range(3):
            if i == 0:
                dp[i][j] = board[i][j]
            else:
                min_cost = int(1e9)
                for k in [0, 1, 2]:
                    if k != j and dp[i - 1][k] < min_cost:
                        min_cost = dp[i - 1][k]
                dp[i][j] = min_cost + board[i][j]

    return min(dp[n - 1])


N = int(sys.stdin.readline())
b = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(N)]
print(solve(N, b))
