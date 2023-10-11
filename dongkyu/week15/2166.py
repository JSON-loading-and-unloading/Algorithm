import sys


def solve(n, points):
    answer = 0
    for i in range(n):
        x1, y1 = points[i]
        x2, y2 = points[(i + 1) % n]
        answer += (x1 * y2 - x2 * y1)
    return round(abs(answer) / 2, 1)


N = int(sys.stdin.readline())
P = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(N)]
print(solve(N, P))
