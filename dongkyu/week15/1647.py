import sys


def find(v, parents):
    if v != parents[v]:
        parents[v] = find(parents[v], parents)
    return parents[v]


def solve(n, roads):
    sum_cost, max_cost = 0, 0
    parents = [0] + [i for i in range(1, n + 1)]
    for s, d, c in sorted(roads, key=lambda x: x[2]):
        sp, dp = find(s, parents), find(d, parents)
        if sp != dp:
            sum_cost += c
            max_cost = max(max_cost, c)
            parents[max(sp, dp)] = min(sp, dp)
    return sum_cost - max_cost


N, M = map(int, sys.stdin.readline().split(' '))
R = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(M)]
print(solve(N, R))
