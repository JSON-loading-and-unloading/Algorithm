import sys

n, m = map(int, sys.stdin.readline().split(" "))
board = [list(map(int, sys.stdin.readline().split(" "))) for _ in range(n)]


def dfs(y, x, count, sum):
    global result
    if count == 4:
        result = max(sum, result)
        return

    for k in range(4):
        ny, nx = y + dy[k], x + dx[k]
        if 0 <= ny < n and 0 <= nx < m and not visited[ny][nx]:
            visited[ny][nx] = True
            dfs(ny, nx, count + 1, sum + board[ny][nx])
            visited[ny][nx] = False


def calculate(y, x):
    global result
    surroundings = []
    for k in range(4):
        ny, nx = y + dy[k], x + dx[k]
        if 0 <= ny < n and 0 <= nx < m:
            surroundings.append(board[ny][nx])

    if len(surroundings) == 3:
        result = max(result, board[y][x] + sum(surroundings))
    elif len(surroundings) == 4:
        idxs = {0, 1, 2, 3}
        for k in range(4):
            temp = 0
            for idx in idxs - {k}:
                temp += surroundings[idx]
            result = max(result, board[y][x] + temp)


result = 0
visited = [[False] * m for _ in range(n)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

for i in range(n):
    for j in range(m):
        visited[i][j] = True
        dfs(i, j, 1, board[i][j])
        visited[i][j] = False
        calculate(i, j)

print(result)
