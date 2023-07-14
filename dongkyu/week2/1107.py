import sys

str_n = sys.stdin.readline()
size = len(str_n)
n = int(str_n)

m = int(sys.stdin.readline())
ex = set(map(int, sys.stdin.readline().split())) if m > 0 else set()
btn = list({0, 1, 2, 3, 4, 5, 6, 7, 8, 9} - ex)


def search(num):
    global result
    if num != '':
        number = int(num)
        result = min(result, abs(number - n) + len(str(number)))

    if len(num) == 6:
        return

    for i in range(len(btn)):
        search(num + str(btn[i]))


result = abs(100 - n)
search('')
print(result)
