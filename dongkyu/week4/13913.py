import sys
from collections import deque


def go(n, k):
    if n > k:
        return [str(x) for x in range(n, k - 1, -1)]
    queue = deque()
    queue.append([n])
    visited = [False] * 100001
    visited[n] = True
    while queue:
        path = queue.popleft()
        x = path[-1]

        if x == k:
            return path

        for nx in [x + 1, x - 1, 2 *x]:
            if 0 <= nx <= 100000 and not visited[nx]:
                visited[nx] = True
                queue.append(path + [nx])


n, k = map(int, sys.stdin.readline().split(" "))
answer = go(n, k)
print(len(answer) - 1)
print(' '.join(map(str, answer)))
