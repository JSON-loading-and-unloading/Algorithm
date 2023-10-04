import sys


def solve(knowing, parties):
    truth = [1] * m
    while True:
        knowing_changed = False
        for i in range(m):
            has_knowing = False
            if truth[i] == 0:
                continue
            for p in parties[i]:
                if p in knowing:
                    truth[i] = 0
                    has_knowing = True
            if has_knowing:
                knowing |= set(parties[i])
                knowing_changed = True

        if not knowing_changed:
            break
    return sum(truth)


n, m = map(int, sys.stdin.readline().split())
knowing = set(list(map(int, sys.stdin.readline().split()))[1:])
parties = [list(map(int, input().split()))[1:] for _ in range(m)]
print(solve(knowing, parties))
