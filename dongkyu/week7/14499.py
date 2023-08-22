import sys


def solve(n, m, x, y, board, commands):
    answer = []
    direction = [(), (0, 1), (0, -1), (-1, 0), (1, 0)]
    line = [0, 0, 0, 0]
    left, right = 0, 0
    is_vertical = True
    for cmd in commands:
        nx, ny = x + direction[cmd][0], y + direction[cmd][1]
        if not (0 <= nx < n and 0 <= ny < m):
            continue

        x, y = nx, ny
        if (is_vertical and cmd <= 2) or (not is_vertical and cmd >= 3):
            temp = [line[0], right, line[2], left]
            left, right = line[3], line[1]
            line = temp
            is_vertical = True if not is_vertical else False

        if sum(direction[cmd]) > 0:
            line = line[1:] + [line[0]]
        else:
            line = [line[3]] + line[0:3]
        answer.append(line[2])

        if board[x][y] == 0:
            board[x][y] = line[0]
        else:
            line[0] = board[x][y]
            board[x][y] = 0
    return answer


n, m, x, y, k = map(int, sys.stdin.readline().split(' '))
b = [list(map(int, sys.stdin.readline().split(' '))) for _ in range(n)]
c = list(map(int, sys.stdin.readline().split(' ')))
print('\n'.join(map(str, solve(n, m, x, y, b, c))))
