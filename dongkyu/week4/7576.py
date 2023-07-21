import sys
from collections import deque


def go(m, n, graph):
    queue = deque()
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                queue.append((i, j, 0))
    dy = [0, 0, 1, -1]
    dx = [1, -1, 0, 0]
    result = 0
    while queue:
        y, x, day = queue.popleft()
        result = max(result, day)

        for i in range(4):
            ny = y + dy[i]
            nx = x + dx[i]

            if 0 <= ny < n and 0 <= nx < m and graph[ny][nx] == 0:
                graph[ny][nx] = 1
                queue.append((ny, nx, day + 1))

    for i in range(n):
        if 0 in graph[i]:
            return -1
    return result


m, n = map(int, sys.stdin.readline().split(" "))
graph = [list(map(int, sys.stdin.readline().split(" "))) for _ in range(n)]
print(go(m, n, graph))
