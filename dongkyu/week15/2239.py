import sys


def valid(num, x, y, board):
    k = 0
    lx, ly = x // 3 * 3, y // 3 * 3
    for i in range(lx, lx + 3):
        for j in range(ly, ly + 3):
            if board[i][j] == num or board[x][k] == num or board[k][y] == num:
                return False
            k += 1
    return True


def search(board, blanks, idx):
    if len(blanks) == idx:
        for b in board:
            print(''.join(map(str, b)))
        exit()

    x, y = blanks[idx]
    for num in range(1, 10):
        if valid(num, x, y, board):
            board[x][y] = num
            search(board, blanks, idx + 1)
            board[x][y] = 0


def solve(board):
    blanks = [(i, j) for i in range(9) for j in range(9) if board[i][j] == 0]
    search(board, blanks, 0)


solve([list(map(int, sys.stdin.readline().strip())) for _ in range(9)])
