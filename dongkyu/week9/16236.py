import sys
from collections import deque


def find(x, y, size, board, n):
    queue = deque([(x, y, 0)])
    visited = [[False] * n for _ in range(n)]
    visited[x][y] = True
    fishes = []
    while queue:
        x, y, time = queue.popleft()
        for nx, ny in [(x - 1, y), (x, y - 1), (x + 1, y), (x, y + 1)]:
            if 0 <= nx < n and 0 <= ny < n and not visited[nx][ny]:
                if 0 < board[nx][ny] < size:
                    visited[nx][ny] = True
                    fishes.append((nx, ny, time + 1))
                elif board[nx][ny] == 0 or board[nx][ny] == size:
                    visited[nx][ny] = True
                    queue.append((nx, ny, time + 1))
    res = sorted(fishes, key=lambda f: (f[2], f[0], f[1]))
    return res[0] if res else (-1, -1, -1)


def solve(n, board):
    answer = 0
    x, y = [(i, j) for i in range(n) for j in range(n) if board[i][j] == 9][0]
    size, eat = 2, 0
    while True:
        board[x][y] = 0
        nx, ny, time = find(x, y, size, board, n)
        if nx == -1:
            break
        answer += time
        eat += 1
        if eat == size:
            size += 1
            eat = 0
        x, y = nx, ny
    return answer


N = int(sys.stdin.readline())
b = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(N)]
print(solve(N, b))
