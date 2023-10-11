import sys


def cal(n, a, b):
    result = [[0] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                result[i][j] += a[i][k] * b[k][j]
                result[i][j] %= 1000
    return result


def solve(n, b, matrix):
    if b == 0:
        return [[1 if a == b else 0 for a in range(n)] for b in range(n)]
    elif b % 2 == 0:
        half = solve(n, b // 2, matrix)
        return cal(n, half, half)
    else:
        return cal(n, matrix, solve(n, b - 1, matrix))


N, B = map(int, sys.stdin.readline().split(' '))
M = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(N)]
for res in solve(N, B, M):
    print(' '.join(map(str, res)))
