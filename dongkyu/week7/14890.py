import sys


def is_valid(line, n, l):
    checked = [0] * n
    for i in range(1, n):
        if abs(line[i - 1] - line[i]) > 1:
            return False
        if line[i - 1] < line[i]:
            if not(i - l >= 0 and len(set(line[i - l:i])) == 1):
                return False
            for j in range(i - l, i):
                if checked[j] == -1:
                    return False
                checked[j] = 1
        elif line[i - 1] > line[i]:
            if not(i + l <= n and len(set(line[i:i + l])) == 1):
                return False
            for j in range(i, i + l):
                if checked[j] == 1:
                    return False
                checked[j] = -1
    return True


def solve(n, l, board):
    answer = 0
    for line in board:
        if is_valid(line, n, l):
            answer += 1

    for tp in zip(*board):
        line = list(tp)
        if is_valid(line, n, l):
            answer += 1
    return answer


n, l = map(int, sys.stdin.readline().split(' '))
b = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(n)]
print(solve(n, l, b))
