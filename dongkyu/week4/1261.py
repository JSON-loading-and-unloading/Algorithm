import sys
from collections import deque


def go(m, n, graph):
    result = n * m
    visited = [[False] * m for _ in range(n)]
    queue = deque()
    blocked = deque()

    queue.append((0, 0, 0))
    visited[0][0] = True
    while queue:
        y, x, count = queue.popleft()

        if y == n - 1 and x == m - 1:
            return count

        for ny, nx in [(y, x + 1), (y, x - 1), (y + 1, x), (y - 1, x)]:
            if 0 <= ny < n and 0 <= nx < m and not visited[ny][nx]:
                visited[ny][nx] = True
                if graph[ny][nx] == 0:
                    queue.append((ny, nx, count))
                else:
                    blocked.append((ny, nx, count + 1))
        if not queue:
            queue.extend(blocked)


m, n = map(int, sys.stdin.readline().split(" "))
graph = [[int(s) for s in sys.stdin.readline().strip()] for _ in range(n)]
print(go(m, n, graph))
