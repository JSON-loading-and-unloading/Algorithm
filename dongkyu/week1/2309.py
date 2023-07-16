import sys

heights = [int(sys.stdin.readline()) for _ in range(9)]
result = []
visited = [False] * 9
flag = False


def search(depth, n, m):
    global flag
    if depth == m:
        if sum(result) == 100:
            flag = True
            sorted_result = sorted(result)
            for res in sorted_result:
                print(res)
            return

    for i in range(n):
        if not visited[i]:
            visited[i] = True
            result.append(heights[i])
            search(depth + 1, n, m)
            if flag:
                return
            visited[i] = False
            result.pop()


search(0, 9, 7)
