import sys
from itertools import product


def cal(bit, paper):
    nums = []
    is_continue = False
    for i in range(n):
        is_continue = False
        for j in range(m):
            if bit[i][j] == 1 and not is_continue:
                nums.append(paper[i][j])
                is_continue = True
            elif bit[i][j] == 1 and is_continue:
                nums[-1] = (nums[-1] * 10 + paper[i][j])
            elif bit[i][j] == 0:
                is_continue = False

    for i in range(m):
        is_continue = False
        for j in range(n):
            if bit[j][i] == 0 and not is_continue:
                nums.append(paper[j][i])
                is_continue = True
            elif bit[j][i] == 0 and is_continue:
                nums[-1] = (nums[-1] * 10 + paper[j][i])
            elif bit[j][i] == 1:
                is_continue = False
    return sum(nums)


def solve(n, m, paper):
    answer = 0
    for bit in list(product([0, 1], repeat=n * m)):
        arr = []
        for i in range(n):
            arr.append(bit[i * m:i * m + m])
        answer = max(answer, cal(arr, paper))
    return answer


n, m = map(int, sys.stdin.readline().split(' '))
paper = [list(map(int, sys.stdin.readline().strip())) for _ in range(n)]
print(solve(n, m, paper))
