import sys


def work(m, arr):
    length = len(arr)
    temp = arr[-1] * 2
    for _ in range(m):
        if length == 1:
            break
        arr.pop()
        length -= 1
    return temp


def solve(n, m, books):
    negatives, positives = [0], [0]
    for i in range(n):
        if books[i] < 0:
            negatives.append(-1 * books[i])
        else:
            positives.append(books[i])
    negatives = sorted(negatives)
    positives = sorted(positives)

    answer = -1 * max(negatives[-1], positives[-1])
    while len(negatives) > 1 or len(positives) > 1:
        if negatives[-1] < positives[-1]:
            answer += work(m, positives)
        else:
            answer += work(m, negatives)
    return answer


n, m = map(int, sys.stdin.readline().split(' '))
books = list(map(int, sys.stdin.readline().split(' ')))
print(solve(n, m, books))
