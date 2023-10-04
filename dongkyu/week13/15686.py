import sys
from itertools import combinations
from collections import deque


def solve(n, m, board):
    chickens = []
    homes = []
    for i in range(n):
        for j in range(n):
            if board[i][j] == 2:
                chickens.append((i, j))
            elif board[i][j] == 1:
                homes.append((i, j))

    combs = list(combinations(chickens, m))
    dists = []
    for comb in combs:
        dists.append(0)
        for x, y in homes:
            dist = int(1e9)
            for r, c in comb:
                dist = min(dist, abs(x - r) + abs(y - c))
            dists[-1] += dist

    return min(dists)


N, M = map(int, sys.stdin.readline().split())
BOARD = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(N)]
print(solve(N, M, BOARD))
