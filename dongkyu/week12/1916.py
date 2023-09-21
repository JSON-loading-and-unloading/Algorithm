import sys
from collections import defaultdict
import heapq as hq


def solve(n, m, costs, start, target):
    graph = defaultdict(list)
    for s, t, c in costs:
        graph[s].append((t, c))
    queue = []
    hq.heappush(queue, (0, start))
    visited = [int(1e9)] * (n + 1)
    visited[start] = 0
    while queue:
        cost, city = hq.heappop(queue)
        if visited[city] < cost:
            continue
        for next_city, next_cost in graph[city]:
            if cost + next_cost < visited[next_city]:
                visited[next_city] = cost + next_cost
                hq.heappush(queue, (cost + next_cost, next_city))
    return visited[target]


N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
COSTS = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(M)]
S, T = map(int, sys.stdin.readline().split(' '))
print(solve(N, M, COSTS, S, T))
