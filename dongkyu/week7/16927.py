import sys


def rotate(arr, s, me, ne):
    left_top = arr[s][s]
    left_bottom = arr[ne - 1][s]
    right_top = arr[s][me - 1]
    right_bottom = arr[ne - 1][me - 1]
    for i in range(s + 1, me):
        arr[s][i - 1] = arr[s][i]
    for i in range(ne - 1, s, -1):
        if i == s + 1:
            arr[i][s] = left_top
        else:
            arr[i][s] = arr[i- 1][s]
    for i in range(me - 1, s, -1):
        if i == s + 1:
            arr[ne - 1][i] = left_bottom
        else:
            arr[ne - 1][i] = arr[ne - 1][i - 1]
    for i in range(s, ne - 1):
        if i == ne - 2:
            arr[i][me - 1] = right_bottom
        else:
            arr[i][me - 1] = arr[i + 1][me - 1]


def solve(n, m, r, arr):
    s, ne, me = 0, n, m
    ro = (n - 1) * 2 + (m - 1) * 2
    while min(m, n) > 0:
        for _ in range(r % ro):
            rotate(arr, s, me, ne)
        ne -= 1
        me -= 1
        s += 1
        m -= 2
        n -= 2
        ro -= 8
    return arr


n, m, r = map(int, sys.stdin.readline().split(' '))
arr = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(n)]
for a in solve(n, m, r, arr):
    print(' '.join(map(str, a)))
