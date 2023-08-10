import sys


def solve(arr, operations, n, m):
    answer = arr
    for o in operations:
        if o == 1:
            answer = answer[::-1]
        elif o == 2:
            answer = [row[::-1] for row in answer]
        elif o == 3:
            n, m = m, n
            answer = [list(reversed(column)) for column in zip(*answer)]
        elif o == 4:
            n, m = m, n
            answer = [list(row) for row in zip(*answer)][::-1]
        elif o == 5:
            temp = [[0] * m for _ in range(n)]
            y, x = n // 2, m // 2
            for i in range(n):
                for j in range(m):
                    if 0 <= i < y and 0 <= j < x:
                        temp[i][j] = answer[i + y][j]
                    elif 0 <= i < y and x <= j < m:
                        temp[i][j] = answer[i][j - x]
                    elif y <= i < n and x <= j < m:
                        temp[i][j] = answer[i - y][j]
                    else:
                        temp[i][j] = answer[i][j - x]
            answer = temp
        else:
            temp = [[0] * m for _ in range(n)]
            y, x = n // 2, m // 2
            for i in range(n):
                for j in range(m):
                    if 0 <= i < y and 0 <= j < x:
                        temp[i][j] = answer[i][j - x]
                    elif 0 <= i < y and x <= j < m:
                        temp[i][j] = answer[i + y][j]
                    elif y <= i < n and x <= j < m:
                        temp[i][j] = answer[i][j - x]
                    else:
                        temp[i][j] = answer[i - y][j]
            answer = temp
    return answer


n, m, r = map(int, sys.stdin.readline().split(' '))
arr = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(n)]
operations = list(map(int, sys.stdin.readline().split(' ')))
for ans in solve(arr, operations, n, m):
    print(' '.join(map(str, ans)))
