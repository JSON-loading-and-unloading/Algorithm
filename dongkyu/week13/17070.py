import sys


def solve(n, board):
    right, down, diagonal = 0, 1, 2
    dp = [[[0 for _ in range(N)] for _ in range(N)] for _ in range(3)]
    dp[right][0][1] = 1
    for i in range(2, n):
        if board[0][i] == 0:
            dp[right][0][i] = dp[right][0][i - 1]

    for r in range(1, n):
        for c in range(1, n):
            if board[r][c] == 0 and board[r][c - 1] == 0 and board[r - 1][c] == 0:
                for i in range(3):
                    dp[diagonal][r][c] += dp[i][r - 1][c - 1]

            if board[r][c] == 0:
                dp[right][r][c] = dp[right][r][c - 1] + dp[diagonal][r][c - 1]
                dp[down][r][c] = dp[down][r - 1][c] + dp[diagonal][r - 1][c]
    return dp[right][n - 1][n - 1] + dp[down][n - 1][n - 1] + dp[diagonal][n - 1][n - 1]


N = int(sys.stdin.readline())
BOARD = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(N)]
print(solve(N, BOARD))
