import sys


def swap(sx, sy, tx, ty):
    board[sx][sy], board[tx][ty] = board[tx][ty], board[sx][sy]


def can_eat():
    max_res = 0
    for i in range(n):
        res = 1
        for j in range(n - 1):
            if board[i][j] == board[i][j + 1]:
                res += 1
                max_res = max(max_res, res)
            else:
                res = 1
    for i in range(n):
        res = 1
        for j in range(n - 1):
            if board[j][i] == board[j + 1][i]:
                res += 1
                max_res = max(max_res, res)
            else:
                res = 1
    return max_res


n = int(sys.stdin.readline())
board = [list(map(str, sys.stdin.readline().rstrip())) for _ in range(n)]
result = can_eat()
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
visited = [[False] * n for _ in range(n)]
for i in range(n):
    for j in range(n):
        visited[i][j] = True
        for k in range(4):
            ni = i + dx[k]
            nj = j + dy[k]
            if 0 <= ni < n and 0 <= nj < n and not visited[ni][nj] and board[i][j] != board[ni][nj]:
                swap(i, j, ni, nj)
                result = max(result, can_eat())
                swap(i, j, ni, nj)


print(result)
