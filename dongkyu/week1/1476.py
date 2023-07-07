import sys

me, ms, mm = 15, 28, 19
e, s, m = map(int, sys.stdin.readline().split(' '))

result = 1
i, j, k = 1, 1, 1
while True:
    if i == e and j == s and k == m:
        print(result)
        break
    else:
        result += 1
        k = k + 1 if (k + 1) <= mm else 1
        j = j + 1 if (j + 1) <= ms else 1
        i = i + 1 if (i + 1) <= me else 1

