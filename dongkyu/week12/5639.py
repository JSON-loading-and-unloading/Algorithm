import sys

sys.setrecursionlimit(10 ** 9)


def postorder(start, end, preorder, answer):
    if start > end:
        return
    root = preorder[start]
    mid = end + 1
    for i in range(start + 1, end + 1):
        if preorder[i] > root:
            mid = i
            break
    postorder(start + 1, mid - 1, preorder, answer)
    postorder(mid, end, preorder, answer)
    answer.append(root)


def solve(preorder):
    answer = []
    postorder(0, len(preorder) - 1, preorder, answer)
    return answer


TREE = []
while True:
    try:
        TREE.append(int(sys.stdin.readline()))
    except:
        break
print('\n'.join(map(str, solve(TREE))))
