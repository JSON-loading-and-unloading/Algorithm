import sys
from itertools import combinations
from collections import deque


def get_time(checked, board, active, n):
    temp = 0
    for i in range(n):
        for j in range(n):
            if checked[i][j] == 0:
                return -1
            if not (board[i][j] == 2 and (i, j) not in active):
                temp = max(temp, checked[i][j])
    return temp - 1


def solve(n, m, board):
    answer = n * n
    viruses = [(i, j) for i in range(n) for j in range(n) if board[i][j] == 2]

    for active in list(combinations(viruses, m)):
        queue = deque()
        checked = [[0] * n for _ in range(n)]
        for i in range(n):
            for j in range(n):
                if 1 <= board[i][j] <= 2:
                    checked[i][j] = board[i][j] - 2
                if (i, j) in active:
                    queue.append((i, j))
                    checked[i][j] = 1

        while queue:
            x, y = queue.popleft()
            for nx, ny in [(x + 1, y), (x - 1, y), (x, y + 1), (x, y - 1)]:
                if (0 <= nx < n and 0 <= ny < n) and checked[nx][ny] == 0:
                    queue.append((nx, ny))
                    checked[nx][ny] = checked[x][y] + 1

        res = get_time(checked, board, active, n)
        if res > -1:
            answer = min(res, answer)
    return answer if answer < n * n else -1


n, m = map(int, sys.stdin.readline().split(' '))
board = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(n)]
print(solve(n, m, board))
