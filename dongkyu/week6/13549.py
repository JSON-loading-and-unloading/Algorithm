import sys
from collections import deque


def solve(n, k):
    queue = deque()
    queue.append((n, 0))
    cache = [-1] * 100001
    cache[n] = 0

    while queue:
        p, time = queue.popleft()
        for x, y in [(p + 1, 1), (p - 1, 1), (2 * p, 0)]:
            if 0 <= x <= 100000 and (cache[x] == -1 or cache[x] > time + y):
                cache[x] = time + y
                queue.append((x, cache[x]))
    return cache[k]


n, k = map(int, sys.stdin.readline().split(' '))
print(solve(n, k))
