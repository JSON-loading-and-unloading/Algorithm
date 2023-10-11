import sys
from collections import defaultdict
import heapq as hq


def solve(n, info):
    dist = [[int(1e9)] * (n + 1) for _ in range(n + 1)]
    graph = defaultdict(list)
    for a, b, c in info:
        graph[a].append((b, c))

    for start in range(1, n + 1):
        dist[start][start] = 0
        queue = []
        hq.heappush(queue, (dist[start][start], start))

        while queue:
            current_dist, current_node = hq.heappop(queue)

            if dist[start][current_node] < current_dist:
                continue

            for next_node, next_dist in graph[current_node]:
                new_dist = current_dist + next_dist
                if new_dist < dist[start][next_node]:
                    dist[start][next_node] = new_dist
                    hq.heappush(queue, (new_dist, next_node))
    return dist


N = int(sys.stdin.readline())
M = int(sys.stdin.readline())
INFO = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(M)]
result = solve(N, INFO)
for i in range(1, N + 1):
    print(' '.join(map(str, [result[i][j] if result[i][j] < int(1e9) else 0 for j in range(1, N + 1)])))

