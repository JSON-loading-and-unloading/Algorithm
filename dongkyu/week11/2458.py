import sys
from collections import defaultdict, deque


def cal(front, i, n):
    queue = deque([i])
    visited = [False] * (n + 1)
    visited[i] = True
    count = 0
    while queue:
        node = queue.popleft()
        for next_node in front[node]:
            if not visited[next_node]:
                visited[next_node] = True
                count += 1
                queue.append(next_node)
    return count


def solve(n, m, info):
    answer = 0
    front, back = defaultdict(list), defaultdict(list)
    for a, b in info:
        back[a].append(b)
        front[b].append(a)

    for i in range(1, n + 1):
        if cal(front, i, n) + cal(back, i, n) == n - 1:
            answer += 1
    return answer


N, M = map(int, sys.stdin.readline().split(' '))
INFO = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(M)]
print(solve(N, M, INFO))
