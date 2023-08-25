import sys


def solution(characteristics):
    answer = 0, 0
    start, end = 0, len(characteristics) - 1
    value = 2000000000
    while start < end:
        s = characteristics[start]
        e = characteristics[end]
        v = s + e
        if abs(v) < value:
            value = abs(v)
            answer = s, e

        if v < 0:
            start += 1
        else:
            end -= 1

    return answer


n = int(sys.stdin.readline())
c = list(map(int, sys.stdin.readline().split(' ')))
print(' '.join(map(str, solution(c))))
