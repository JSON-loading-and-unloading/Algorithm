import sys
from itertools import combinations
from collections import deque


def is_link(checked):
    r, c = checked[0]
    queue = deque([(r, c)])
    count = 1
    visited = [[False] * 5 for _ in range(5)]
    visited[r][c] = True
    while queue:
        r, c = queue.popleft()
        for nr, nc in [(r + 1, c), (r - 1, c), (r, c + 1), (r, c - 1)]:
            if (nr, nc) in checked and not visited[nr][nc]:
                visited[nr][nc] = True
                count += 1
                queue.append((nr, nc))
    if count == 7:
        return True
    return False


def solve(board):
    answer = 0
    seats = [(i, j) for j in range(5) for i in range(5)]
    combs = list(combinations(seats, 7))
    for comb in combs:
        if not is_link(comb):
            continue
        som = 0
        for x, y in comb:
            if board[x][y] == 'S':
                som += 1
        if som >= 4:
            answer += 1
    return answer


BOARD = [list(sys.stdin.readline().strip()) for _ in range(5)]
print(solve(BOARD))
