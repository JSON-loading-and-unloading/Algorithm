import sys
from collections import defaultdict

sys.setrecursionlimit(10 ** 6)


def dfs(edges_dict, groups, node):
    for j in edges_dict[node]:
        if groups[j] == -1:
            groups[j] = 1 if groups[node] == 0 else 0
            if not dfs(edges_dict, groups, j):
                return False
        elif groups[j] == groups[node]:
            return False
    return True


def solve(v, edges):
    edges_dict = defaultdict(list)
    for x, y in edges:
        edges_dict[x].append(y)
        edges_dict[y].append(x)

    groups = [-1] * (v + 1)
    for i in range(1, v + 1):
        if groups[i] == -1:
            groups[i] = 0
            if not dfs(edges_dict, groups, i):
                return 'NO'
    return 'YES'


k = int(sys.stdin.readline())
answers = []
for _ in range(k):
    v, e = map(int, sys.stdin.readline().split(' '))
    edges = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(e)]
    answers.append(solve(v, edges))
print('\n'.join(answers))
