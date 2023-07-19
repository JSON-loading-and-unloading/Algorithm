import sys


def go(m, n, x, y):
    while x <= m * n:
        if x % n == y % n:
            return x
        x += m
    return -1


t = int(sys.stdin.readline())
answers = []

for _ in range(t):
    m, n, x, y = map(int, sys.stdin.readline().split(" "))
    answers.append(go(m, n, x, y))

for answer in answers:
    print(answer)
